package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.FormatSize
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.model.Story
import com.example.data.model.StoryChoice
import com.example.ui.theme.MoonGold
import com.example.ui.theme.NightCard
import com.example.ui.theme.PrimaryPurple
import com.example.ui.theme.SecondaryCoral
import com.example.ui.theme.StarYellow

@Composable
fun StoryReaderScreen(
    story: Story,
    currentPageIndex: Int,
    isAudioPlaying: Boolean,
    isNightMode: Boolean,
    fontSizeScale: Float,
    onNextPage: () -> Unit,
    onPreviousPage: () -> Unit,
    onChoiceClick: (targetPage: Int) -> Unit,
    onToggleAudio: () -> Unit,
    onToggleNightMode: () -> Unit,
    onChangeFontSize: (Float) -> Unit,
    onBackClick: () -> Unit,
    onStoryFinished: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val page = story.pages.getOrNull(currentPageIndex)
    val totalPages = story.pages.size

    Surface(
        modifier = modifier.fillMaxSize(),
        color = if (isNightMode) Color(0xFF0F172A) else MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Reader Top Control Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.testTag("reader_back_button")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "بازگشت",
                        tint = if (isNightMode) Color.White else MaterialTheme.colorScheme.onSurface
                    )
                }

                Surface(
                    shape = RoundedCornerShape(20.dp),
                    color = if (isNightMode) NightCard else MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        text = "صفحه ${currentPageIndex + 1} از $totalPages",
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                        color = if (isNightMode) MoonGold else MaterialTheme.colorScheme.primary
                    )
                }

                Row {
                    // Font Scale Toggle
                    IconButton(onClick = {
                        val nextScale = when (fontSizeScale) {
                            1.0f -> 1.25f
                            1.25f -> 1.5f
                            else -> 1.0f
                        }
                        onChangeFontSize(nextScale)
                    }) {
                        Icon(
                            imageVector = Icons.Filled.FormatSize,
                            contentDescription = "تغییر اندازه متن",
                            tint = if (isNightMode) MoonGold else MaterialTheme.colorScheme.primary
                        )
                    }

                    // Night Mode Toggle
                    IconButton(onClick = onToggleNightMode) {
                        Icon(
                            imageVector = if (isNightMode) Icons.Filled.WbSunny else Icons.Filled.Nightlight,
                            contentDescription = "حالت شب",
                            tint = if (isNightMode) MoonGold else MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Main Reader Content Canvas
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (page != null) {
                    // Page Illustration Header
                    val imageRes = if (story.isBedtimeStory || isNightMode) R.drawable.img_night else R.drawable.img_hero
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        shape = RoundedCornerShape(28.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Page Text with Dynamic Scale
                    val baseFontSize = 20.sp * fontSizeScale
                    val baseLineHeight = 32.sp * fontSizeScale

                    Text(
                        text = page.text,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontSize = baseFontSize,
                            lineHeight = baseLineHeight,
                            fontWeight = FontWeight.Medium
                        ),
                        color = if (isNightMode) Color.White else MaterialTheme.colorScheme.onSurface,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Interactive Branching Decision Choices
                    if (page.choices.isNotEmpty()) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(24.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = if (isNightMode) NightCard else StarYellow.copy(alpha = 0.3f)
                            )
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "تو جای شخصیت داستان بودی چه کار می‌کردی؟ 🤔",
                                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                                    color = if (isNightMode) MoonGold else MaterialTheme.colorScheme.primary
                                )

                                Spacer(modifier = Modifier.height(12.dp))

                                page.choices.forEach { choice ->
                                    Button(
                                        onClick = { onChoiceClick(choice.targetPageNumber) },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp),
                                        shape = RoundedCornerShape(16.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple)
                                    ) {
                                        Text(
                                            text = choice.optionText,
                                            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                                            color = Color.White
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Reader Bottom Control Bar
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                color = if (isNightMode) NightCard else MaterialTheme.colorScheme.surface,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Previous Button
                    Button(
                        onClick = onPreviousPage,
                        enabled = currentPageIndex > 0,
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryPurple)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "صفحه قبلی"
                        )
                    }

                    // Audio Play/Pause Button
                    IconButton(
                        onClick = onToggleAudio,
                        modifier = Modifier
                            .size(52.dp)
                            .background(
                                color = if (isAudioPlaying) SecondaryCoral else PrimaryPurple,
                                shape = CircleShape
                            )
                            .testTag("audio_toggle_button")
                    ) {
                        Icon(
                            imageVector = if (isAudioPlaying) Icons.Filled.Pause else Icons.Filled.Headphones,
                            contentDescription = "شنیدن صوت",
                            tint = Color.White,
                            modifier = Modifier.size(26.dp)
                        )
                    }

                    // Next / Finish Button
                    Button(
                        onClick = {
                            if (currentPageIndex < totalPages - 1) {
                                onNextPage()
                            } else {
                                onStoryFinished()
                            }
                        },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (currentPageIndex == totalPages - 1) StarYellow else PrimaryPurple
                        ),
                        modifier = Modifier.testTag("reader_next_button")
                    ) {
                        Text(
                            text = if (currentPageIndex == totalPages - 1) "پایان قصه 🌟" else "صفحه بعدی",
                            color = if (currentPageIndex == totalPages - 1) Color.Black else Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "بعدی",
                            tint = if (currentPageIndex == totalPages - 1) Color.Black else Color.White
                        )
                    }
                }
            }
        }
    }
}
