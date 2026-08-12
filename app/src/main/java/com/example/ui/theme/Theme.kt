package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// 1. Qesseh Brand Custom Theme (Signature Theme - Royal Purple & Star Gold)
private val QessehBrandColorScheme = lightColorScheme(
    primary = PrimaryPurple,            // 0xFF7C3AED
    onPrimary = Color.White,
    primaryContainer = PrimaryPurpleContainer, // 0xFFF3E8FF
    onPrimaryContainer = PrimaryPurple,
    secondary = SecondaryCoral,         // 0xFFFF6B6B
    onSecondary = Color.White,
    tertiary = StarYellow,             // 0xFFFFB703
    onTertiary = TextPrimaryDark,
    background = SoftBackground,       // 0xFFF5F0FF
    onBackground = TextPrimaryDark,
    surface = CardBackground,           // 0xFFFFFFFF
    onSurface = TextPrimaryDark,
    surfaceVariant = PrimaryPurpleContainer,
    onSurfaceVariant = TextSecondaryMuted,
    outline = Color(0xFFC084FC)
)

// 2. Standard Pure Light Theme
private val QessehLightColorScheme = lightColorScheme(
    primary = Color(0xFF6366F1),        // Indigo Blue
    onPrimary = Color.White,
    primaryContainer = Color(0xFFEEF2FF),
    onPrimaryContainer = Color(0xFF3730A3),
    secondary = SkyBlue,                // Sky Blue
    onSecondary = Color.White,
    tertiary = StarYellow,
    onTertiary = Color(0xFF1E293B),
    background = Color(0xFFF8FAFC),      // Slate Crisp Light
    onBackground = Color(0xFF0F172A),
    surface = Color.White,
    onSurface = Color(0xFF0F172A),
    surfaceVariant = Color(0xFFF1F5F9),
    onSurfaceVariant = Color(0xFF64748B),
    outline = Color(0xFFCBD5E1)
)

// 3. Standard Pure Dark Theme
private val QessehDarkColorScheme = darkColorScheme(
    primary = DarkPurplePrimary,        // 0xFFC084FC
    onPrimary = Color(0xFF1B1433),
    primaryContainer = DarkPurpleCard,  // 0xFF33275B
    onPrimaryContainer = NeonGold,
    secondary = DarkPurpleAccent,
    onSecondary = DarkPurpleBackground,
    tertiary = NeonGold,
    onTertiary = DarkPurpleBackground,
    background = DarkPurpleBackground,  // 0xFF1B1433
    onBackground = SoftStarWhite,
    surface = DarkPurpleSurface,       // 0xFF261D45
    onSurface = SoftStarWhite,
    surfaceVariant = DarkPurpleCard,
    onSurfaceVariant = MutedPurpleText,
    outline = DarkPurpleCardBorder
)

@Composable
fun QessehKhanehTheme(
    themeMode: String = "brand_custom", // "brand_custom", "system", "light", "dark"
    isNightMode: Boolean = false,
    content: @Composable () -> Unit
) {
    val systemInDark = isSystemInDarkTheme()

    val colorScheme = when {
        isNightMode -> QessehDarkColorScheme
        themeMode == "system" -> if (systemInDark) QessehDarkColorScheme else QessehBrandColorScheme
        themeMode == "light" -> QessehLightColorScheme
        themeMode == "dark" -> QessehDarkColorScheme
        themeMode == "brand_custom" -> QessehBrandColorScheme
        else -> QessehBrandColorScheme // Default to Brand Custom Theme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}


