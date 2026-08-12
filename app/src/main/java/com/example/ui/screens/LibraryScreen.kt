package com.example.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.local.SampleData
import com.example.data.model.Story
import com.example.ui.components.CategoryChip
import com.example.ui.components.StoryCard

@Composable
fun LibraryScreen(
    stories: List<Story>,
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    selectedCategory: String,
    onCategorySelect: (String) -> Unit,
    selectedAgeGroup: String?,
    onAgeGroupSelect: (String?) -> Unit,
    onStoryClick: (Story) -> Unit,
    onFavoriteToggle: (Story) -> Unit,
    modifier: Modifier = Modifier
) {
    val filteredStories = stories.filter { story ->
        val matchesCategory = selectedCategory == "cat_all" || story.categoryId == selectedCategory
        val matchesAge = selectedAgeGroup == null || story.ageGroup == selectedAgeGroup
        val matchesQuery = searchQuery.isBlank() ||
                story.title.contains(searchQuery, ignoreCase = true) ||
                story.description.contains(searchQuery, ignoreCase = true) ||
                story.moralLesson.contains(searchQuery, ignoreCase = true)

        matchesCategory && matchesAge && matchesQuery
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        // Search Header
        OutlinedTextField(
            value = searchQuery,
            onValueChange = onSearchChange,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("library_search_input"),
            placeholder = { Text("جستجوی داستان، شخصیت یا موضوع...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { onSearchChange("") }) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = "پاک کردن")
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Age Group Chips
        val ageList = listOf("۳-۵", "۶-۸", "۹-۱۲", "۱۳+")
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                FilterChip(
                    selected = selectedAgeGroup == null,
                    onClick = { onAgeGroupSelect(null) },
                    label = { Text("همه سنین") }
                )
            }
            items(ageList) { age ->
                FilterChip(
                    selected = selectedAgeGroup == age,
                    onClick = { onAgeGroupSelect(if (selectedAgeGroup == age) null else age) },
                    label = { Text("رده $age سال") }
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Category Chips
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(SampleData.categories) { cat ->
                CategoryChip(
                    category = cat,
                    isSelected = cat.id == selectedCategory,
                    onSelect = { onCategorySelect(cat.id) }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (filteredStories.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_mascot),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "هنوز قصهای اینجا منتظر تو نیست! 🎈",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "بیا با تغییر دستهبندی یا جستجو، یک قصه قشنگ پیدا کنیم.",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(filteredStories) { story ->
                    StoryCard(
                        story = story,
                        onStoryClick = { onStoryClick(story) },
                        onFavoriteToggle = { onFavoriteToggle(story) }
                    )
                }
            }
        }
    }
}
