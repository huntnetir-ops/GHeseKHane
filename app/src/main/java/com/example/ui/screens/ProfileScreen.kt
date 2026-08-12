package com.example.ui.screens

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.RecordVoiceOver
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.model.ChildProfile
import com.example.data.model.Story
import com.example.ui.components.ParentPinDialog
import com.example.ui.components.StoryCard
import com.example.ui.theme.DarkPurplePrimary
import com.example.ui.theme.NightNavy
import com.example.ui.theme.PrimaryPurple
import com.example.ui.theme.SecondaryCoral
import com.example.ui.theme.StarYellow

@Composable
fun ProfileScreen(
    currentProfile: ChildProfile?,
    allProfiles: List<ChildProfile>,
    favoriteStories: List<Story>,
    isParentUnlocked: Boolean,
    sleepTimerMinutes: Int?,
    themeMode: String = "dark_purple",
    fontSizeScale: Float = 1.0f,
    narrationSpeed: Float = 1.0f,
    ambientSound: String = "none",
    autoAdvancePage: Boolean = true,
    highlightSentence: Boolean = true,
    dailyLimitMinutes: Int? = 30,
    bedtimeReminderTime: String? = "21:00",
    onSelectProfile: (Long) -> Unit,
    onVerifyPin: (String) -> Boolean,
    onLockParentZone: () -> Unit,
    onSetSleepTimer: (Int) -> Unit,
    onCancelSleepTimer: () -> Unit,
    onSetThemeMode: (String) -> Unit = {},
    onSetFontSizeScale: (Float) -> Unit = {},
    onSetNarrationSpeed: (Float) -> Unit = {},
    onSetAmbientSound: (String) -> Unit = {},
    onToggleAutoAdvancePage: () -> Unit = {},
    onToggleHighlightSentence: () -> Unit = {},
    onSetDailyLimitMinutes: (Int?) -> Unit = {},
    onSetBedtimeReminderTime: (String?) -> Unit = {},
    onChangeParentPin: (String) -> Unit = {},
    onResetProgressData: () -> Unit = {},
    onStoryClick: (Story) -> Unit,
    onFavoriteToggle: (Story) -> Unit,
    modifier: Modifier = Modifier
) {
    var showPinDialog by remember { mutableStateOf(false) }
    var showResetConfirmDialog by remember { mutableStateOf(false) }
    var showChangePinDialog by remember { mutableStateOf(false) }
    var newPinInput by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    if (showPinDialog) {
        ParentPinDialog(
            onDismiss = { showPinDialog = false },
            onSuccess = { showPinDialog = false },
            onVerifyPin = onVerifyPin
        )
    }

    if (showResetConfirmDialog) {
        AlertDialog(
            onDismissRequest = { showResetConfirmDialog = false },
            title = { Text("بازنشانی تاریخچه و علامت‌ها", fontWeight = FontWeight.Bold) },
            text = { Text("آیا مطمئن هستید؟ با این کار تمام داستان‌های تکمیل‌شده و نشان‌های دریافت شده بازنشانی خواهند شد.") },
            confirmButton = {
                Button(
                    onClick = {
                        onResetProgressData()
                        showResetConfirmDialog = false
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = SecondaryCoral)
                ) {
                    Text("بله، بازنشانی شود")
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetConfirmDialog = false }) {
                    Text("انصراف")
                }
            }
        )
    }

    if (showChangePinDialog) {
        AlertDialog(
            onDismissRequest = { showChangePinDialog = false },
            title = { Text("تغییر پین‌کد بخش والدین", fontWeight = FontWeight.Bold) },
            text = {
                Column {
                    Text("پین ۴ رقمی جدید خود را وارد کنید:")
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = newPinInput,
                        onValueChange = { if (it.length <= 4) newPinInput = it },
                        label = { Text("پین‌کد جدید") },
                        singleLine = true
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (newPinInput.length == 4) {
                            onChangeParentPin(newPinInput)
                            showChangePinDialog = false
                            newPinInput = ""
                        }
                    },
                    enabled = newPinInput.length == 4
                ) {
                    Text("ثبت پین‌کد")
                }
            },
            dismissButton = {
                TextButton(onClick = { showChangePinDialog = false }) {
                    Text("انصراف")
                }
            }
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Active Profile Header Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.img_mascot),
                        contentDescription = null,
                        modifier = Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .border(3.dp, DarkPurplePrimary, CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(
                            text = currentProfile?.name ?: "دوست کوچولو",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "رده سنی ${currentProfile?.age ?: 7} سال • علاقمند به ${currentProfile?.interests?.joinToString("، ") ?: "قصه‌ها"}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Child Profiles Row
                Text(
                    text = "تعویض پروفایل کودک:",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(allProfiles) { prof ->
                        val isSel = prof.id == currentProfile?.id
                        Surface(
                            modifier = Modifier.clickable { onSelectProfile(prof.id) },
                            shape = RoundedCornerShape(16.dp),
                            color = if (isSel) DarkPurplePrimary else MaterialTheme.colorScheme.surface
                        ) {
                            Text(
                                text = prof.name,
                                modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                                color = if (isSel) Color.White else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Favorites Carousel
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                tint = SecondaryCoral
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "قصههای محبوب من (${favoriteStories.size}) ❤️",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (favoriteStories.isEmpty()) {
            Text(
                text = "هنوز داستان مورد علاقه‌ای علامت نزدی. با لمس قلب روی داستان‌ها، آن‌ها را به این لیست اضافه کن!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(favoriteStories) { favStory ->
                    Box(modifier = Modifier.width(260.dp)) {
                        StoryCard(
                            story = favStory,
                            onStoryClick = { onStoryClick(favStory) },
                            onFavoriteToggle = { onFavoriteToggle(favStory) }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Theme & Appearance Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.Palette, contentDescription = null, tint = DarkPurplePrimary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "تنظیمات پوسته و ظاهر برنامه 🎨",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("انتخاب تم رنگی برنامه:", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(8.dp))
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        FilterChip(
                            selected = themeMode == "brand_custom",
                            onClick = { onSetThemeMode("brand_custom") },
                            label = { Text("✨ تم اختصاصی قصه‌خانه (پیش‌فرض)", fontWeight = FontWeight.Bold) },
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MaterialTheme.colorScheme.primary, selectedLabelColor = Color.White)
                        )
                        FilterChip(
                            selected = themeMode == "system",
                            onClick = { onSetThemeMode("system") },
                            label = { Text("📱 متناسب با سیستم") },
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MaterialTheme.colorScheme.primary, selectedLabelColor = Color.White)
                        )
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        FilterChip(
                            selected = themeMode == "light",
                            onClick = { onSetThemeMode("light") },
                            label = { Text("☀️ تم روشن") },
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MaterialTheme.colorScheme.primary, selectedLabelColor = Color.White)
                        )
                        FilterChip(
                            selected = themeMode == "dark",
                            onClick = { onSetThemeMode("dark") },
                            label = { Text("🌙 تم تاریک") },
                            colors = FilterChipDefaults.filterChipColors(selectedContainerColor = MaterialTheme.colorScheme.primary, selectedLabelColor = Color.White)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("اندازه فونت متن قصه:", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = fontSizeScale == 0.85f,
                        onClick = { onSetFontSizeScale(0.85f) },
                        label = { Text("کوچک (14sp)") }
                    )
                    FilterChip(
                        selected = fontSizeScale == 1.0f,
                        onClick = { onSetFontSizeScale(1.0f) },
                        label = { Text("معمولی (16sp)") }
                    )
                    FilterChip(
                        selected = fontSizeScale == 1.25f,
                        onClick = { onSetFontSizeScale(1.25f) },
                        label = { Text("بزرگ (18sp)") }
                    )
                    FilterChip(
                        selected = fontSizeScale == 1.5f,
                        onClick = { onSetFontSizeScale(1.5f) },
                        label = { Text("خیلی بزرگ (22sp)") }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Narration & Audio Settings Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Filled.RecordVoiceOver, contentDescription = null, tint = DarkPurplePrimary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "تنظیمات قرائت و صدای راوی 🔊",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("سرعت گوینده داستان:", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = narrationSpeed == 0.75f,
                        onClick = { onSetNarrationSpeed(0.75f) },
                        label = { Text("0.75x (آهسته)") }
                    )
                    FilterChip(
                        selected = narrationSpeed == 1.0f,
                        onClick = { onSetNarrationSpeed(1.0f) },
                        label = { Text("1.0x (معمولی)") }
                    )
                    FilterChip(
                        selected = narrationSpeed == 1.25f,
                        onClick = { onSetNarrationSpeed(1.25f) },
                        label = { Text("1.25x (تند)") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("صدای پیش‌زمینه آرامش‌بخش:", style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = ambientSound == "none",
                        onClick = { onSetAmbientSound("none") },
                        label = { Text("خاموش 🔇") }
                    )
                    FilterChip(
                        selected = ambientSound == "rain",
                        onClick = { onSetAmbientSound("rain") },
                        label = { Text("باران و نسیم 🌧️") }
                    )
                    FilterChip(
                        selected = ambientSound == "lullaby",
                        onClick = { onSetAmbientSound("lullaby") },
                        label = { Text("لالایی رویایی 🎵") }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("ورق زدن خودکار صفحه بعد پس از صوتی:", style = MaterialTheme.typography.bodyMedium)
                    Switch(checked = autoAdvancePage, onCheckedChange = { onToggleAutoAdvancePage() })
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("برجسته‌سازی خط در حال خوانش:", style = MaterialTheme.typography.bodyMedium)
                    Switch(checked = highlightSentence, onCheckedChange = { onToggleHighlightSentence() })
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Parent Zone & Controls Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = null,
                            tint = PrimaryPurple,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "بخش والدین و کنترل پیشرفته 🔒",
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                    }

                    if (isParentUnlocked) {
                        Button(
                            onClick = onLockParentZone,
                            colors = ButtonDefaults.buttonColors(containerColor = SecondaryCoral)
                        ) {
                            Text("قفل کردن")
                        }
                    } else {
                        Button(
                            onClick = { showPinDialog = true },
                            modifier = Modifier.testTag("open_parent_zone_button")
                        ) {
                            Text("ورود به تنظیمات")
                        }
                    }
                }

                if (isParentUnlocked) {
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "تایمر خواب قبل از خاموشی (Sleep Timer) 🌙",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    if (sleepTimerMinutes != null && sleepTimerMinutes > 0) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "تایمر خواب فعال است: $sleepTimerMinutes دقیقه باقی مانده",
                                color = DarkPurplePrimary,
                                fontWeight = FontWeight.Bold
                            )
                            OutlinedButton(onClick = onCancelSleepTimer) {
                                Text("لغو تایمر")
                            }
                        }
                    } else {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(onClick = { onSetSleepTimer(15) }) { Text("۱۵ دقیقه") }
                            Button(onClick = { onSetSleepTimer(30) }) { Text("۳۰ دقیقه") }
                            Button(onClick = { onSetSleepTimer(45) }) { Text("۴۵ دقیقه") }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "سقف زمان مطالعه روزانه کودک:",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        FilterChip(
                            selected = dailyLimitMinutes == 15,
                            onClick = { onSetDailyLimitMinutes(15) },
                            label = { Text("۱۵ دقیقه") }
                        )
                        FilterChip(
                            selected = dailyLimitMinutes == 30,
                            onClick = { onSetDailyLimitMinutes(30) },
                            label = { Text("۳۰ دقیقه") }
                        )
                        FilterChip(
                            selected = dailyLimitMinutes == 60,
                            onClick = { onSetDailyLimitMinutes(60) },
                            label = { Text("۶۰ دقیقه") }
                        )
                        FilterChip(
                            selected = dailyLimitMinutes == null,
                            onClick = { onSetDailyLimitMinutes(null) },
                            label = { Text("نامحدود") }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "یادآور قصه شبانه:",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        FilterChip(
                            selected = bedtimeReminderTime == "20:00",
                            onClick = { onSetBedtimeReminderTime("20:00") },
                            label = { Text("۲۰:۰۰ 🕗") }
                        )
                        FilterChip(
                            selected = bedtimeReminderTime == "21:00",
                            onClick = { onSetBedtimeReminderTime("21:00") },
                            label = { Text("۲۱:۰۰ 🕘") }
                        )
                        FilterChip(
                            selected = bedtimeReminderTime == "22:00",
                            onClick = { onSetBedtimeReminderTime("22:00") },
                            label = { Text("۲۲:۰۰ 🕙") }
                        )
                        FilterChip(
                            selected = bedtimeReminderTime == null,
                            onClick = { onSetBedtimeReminderTime(null) },
                            label = { Text("خاموش") }
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedButton(onClick = { showChangePinDialog = true }) {
                            Icon(Icons.Filled.Lock, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("تغییر پین‌کد ورود")
                        }

                        OutlinedButton(
                            onClick = { showResetConfirmDialog = true },
                            colors = ButtonDefaults.outlinedButtonColors(contentColor = SecondaryCoral)
                        ) {
                            Icon(Icons.Filled.Refresh, contentDescription = null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("بازنشانی تاریخچه")
                        }
                    }
                }
            }
        }
    }
}

