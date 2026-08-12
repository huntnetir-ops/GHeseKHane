package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ui.screens.AchievementsScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.LibraryScreen
import com.example.ui.screens.OnboardingScreen
import com.example.ui.screens.ProfileScreen
import com.example.ui.screens.SplashScreen
import com.example.ui.screens.StoryAfterthoughtScreen
import com.example.ui.screens.StoryDetailScreen
import com.example.ui.screens.StoryReaderScreen
import com.example.ui.screens.WorldExplorerScreen
import com.example.ui.theme.PrimaryPurple
import com.example.ui.theme.QessehKhanehTheme
import com.example.ui.theme.StarYellow
import com.example.ui.viewmodel.AppViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val viewModel: AppViewModel = viewModel()
            val isNightMode by viewModel.isNightMode.collectAsState()
            val themeMode by viewModel.themeMode.collectAsState()

            // RTL Local Provider for natural Persian Reading & Layout direction
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                QessehKhanehTheme(themeMode = themeMode, isNightMode = isNightMode) {
                    QessehApp(viewModel = viewModel)
                }
            }
        }
    }
}

sealed class Screen(val route: String, val title: String, val icon: @Composable () -> Unit) {
    object Home : Screen("home", "خانه", { Icon(Icons.Filled.Home, contentDescription = "خانه") })
    object Stories : Screen("stories", "قصه‌ها", { Icon(Icons.Filled.Book, contentDescription = "قصه‌ها") })
    object World : Screen("world", "دنیای من", { Icon(Icons.Filled.Explore, contentDescription = "دنیای من") })
    object Achievements : Screen("achievements", "نشان‌ها", { Icon(Icons.Filled.Star, contentDescription = "نشان‌ها") })
    object Profile : Screen("profile", "پروفایل", { Icon(Icons.Filled.Person, contentDescription = "پروفایل") })
}

@Composable
fun QessehApp(viewModel: AppViewModel) {
    val navController = rememberNavController()

    // ViewModel States
    val currentProfile by viewModel.currentProfile.collectAsState()
    val allProfiles by viewModel.allProfiles.collectAsState()
    val allStories by viewModel.allStories.collectAsState()
    val favoriteStories by viewModel.favoriteStories.collectAsState()
    val bedtimeStories by viewModel.bedtimeStories.collectAsState()

    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedCategory by viewModel.selectedCategoryId.collectAsState()
    val selectedAgeGroup by viewModel.selectedAgeGroup.collectAsState()

    val activeStory by viewModel.activeStory.collectAsState()
    val currentPageIndex by viewModel.currentPageIndex.collectAsState()
    val isAudioPlaying by viewModel.isAudioPlaying.collectAsState()
    val isNightMode by viewModel.isNightMode.collectAsState()
    val themeMode by viewModel.themeMode.collectAsState()
    val fontSizeScale by viewModel.fontSizeScale.collectAsState()
    val narrationSpeed by viewModel.narrationSpeed.collectAsState()
    val ambientSound by viewModel.ambientSound.collectAsState()
    val autoAdvancePage by viewModel.autoAdvancePage.collectAsState()
    val highlightSentence by viewModel.highlightSentence.collectAsState()
    val dailyLimitMinutes by viewModel.dailyLimitMinutes.collectAsState()
    val bedtimeReminderTime by viewModel.bedtimeReminderTime.collectAsState()

    val earnedAchievements by viewModel.earnedAchievements.collectAsState()
    val allAchievements by viewModel.allAchievements.collectAsState()
    val streakDays by viewModel.readingStreakDays.collectAsState()

    val isParentUnlocked by viewModel.isParentUnlocked.collectAsState()
    val sleepTimerMinutes by viewModel.sleepTimerMinutes.collectAsState()

    val bottomNavItems = listOf(
        Screen.Home,
        Screen.Stories,
        Screen.World,
        Screen.Achievements,
        Screen.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar = currentRoute in bottomNavItems.map { it.route }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                NavigationBar(
                    containerColor = PrimaryPurple,
                    contentColor = Color.White
                ) {
                    bottomNavItems.forEach { screen ->
                        val selected = currentRoute == screen.route
                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = screen.icon,
                            label = { Text(screen.title, fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal) },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = PrimaryPurple,
                                selectedTextColor = StarYellow,
                                unselectedIconColor = Color.White.copy(alpha = 0.7f),
                                unselectedTextColor = Color.White.copy(alpha = 0.7f),
                                indicatorColor = StarYellow
                            ),
                            modifier = Modifier.testTag("nav_item_${screen.route}")
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "splash",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("splash") {
                SplashScreen(
                    onSplashFinished = {
                        if (currentProfile == null) {
                            navController.navigate("onboarding") {
                                popUpTo("splash") { inclusive = true }
                            }
                        } else {
                            navController.navigate(Screen.Home.route) {
                                popUpTo("splash") { inclusive = true }
                            }
                        }
                    }
                )
            }

            composable("onboarding") {
                OnboardingScreen(
                    onCompleteOnboarding = { name, age, avatarId, interests ->
                        viewModel.createProfile(name, age, avatarId, interests)
                        navController.navigate(Screen.Home.route) {
                            popUpTo("onboarding") { inclusive = true }
                        }
                    }
                )
            }

            composable(Screen.Home.route) {
                HomeScreen(
                    profile = currentProfile,
                    stories = allStories,
                    bedtimeStories = bedtimeStories,
                    selectedCategory = selectedCategory,
                    onCategorySelect = { viewModel.setCategoryFilter(it) },
                    onStoryClick = { story ->
                        viewModel.openStory(story)
                        navController.navigate("storyDetail/${story.id}")
                    },
                    onFavoriteToggle = { story ->
                        viewModel.toggleFavorite(story.id, story.isFavorite)
                    },
                    onNavigateToWorldExplorer = {
                        navController.navigate(Screen.World.route)
                    }
                )
            }

            composable(Screen.Stories.route) {
                LibraryScreen(
                    stories = allStories,
                    searchQuery = searchQuery,
                    onSearchChange = { viewModel.setSearchQuery(it) },
                    selectedCategory = selectedCategory,
                    onCategorySelect = { viewModel.setCategoryFilter(it) },
                    selectedAgeGroup = selectedAgeGroup,
                    onAgeGroupSelect = { viewModel.setAgeGroupFilter(it) },
                    onStoryClick = { story ->
                        viewModel.openStory(story)
                        navController.navigate("storyDetail/${story.id}")
                    },
                    onFavoriteToggle = { story ->
                        viewModel.toggleFavorite(story.id, story.isFavorite)
                    }
                )
            }

            composable(Screen.World.route) {
                WorldExplorerScreen(
                    facts = viewModel.worldFacts,
                    games = viewModel.miniGames
                )
            }

            composable(Screen.Achievements.route) {
                AchievementsScreen(
                    achievements = allAchievements,
                    earnedAchievements = earnedAchievements,
                    streakDays = streakDays
                )
            }

            composable(Screen.Profile.route) {
                ProfileScreen(
                    currentProfile = currentProfile,
                    allProfiles = allProfiles,
                    favoriteStories = favoriteStories,
                    isParentUnlocked = isParentUnlocked,
                    sleepTimerMinutes = sleepTimerMinutes,
                    themeMode = themeMode,
                    fontSizeScale = fontSizeScale,
                    narrationSpeed = narrationSpeed,
                    ambientSound = ambientSound,
                    autoAdvancePage = autoAdvancePage,
                    highlightSentence = highlightSentence,
                    dailyLimitMinutes = dailyLimitMinutes,
                    bedtimeReminderTime = bedtimeReminderTime,
                    onSelectProfile = { viewModel.selectProfile(it) },
                    onVerifyPin = { pin -> viewModel.verifyParentPin(pin) },
                    onLockParentZone = { viewModel.lockParentZone() },
                    onSetSleepTimer = { mins -> viewModel.setSleepTimer(mins) },
                    onCancelSleepTimer = { viewModel.cancelSleepTimer() },
                    onSetThemeMode = { viewModel.setThemeMode(it) },
                    onSetFontSizeScale = { viewModel.setFontSizeScale(it) },
                    onSetNarrationSpeed = { viewModel.setNarrationSpeed(it) },
                    onSetAmbientSound = { viewModel.setAmbientSound(it) },
                    onToggleAutoAdvancePage = { viewModel.toggleAutoAdvancePage() },
                    onToggleHighlightSentence = { viewModel.toggleHighlightSentence() },
                    onSetDailyLimitMinutes = { viewModel.setDailyLimitMinutes(it) },
                    onSetBedtimeReminderTime = { viewModel.setBedtimeReminderTime(it) },
                    onChangeParentPin = { viewModel.changeParentPin(it) },
                    onResetProgressData = { viewModel.resetProgressData() },
                    onStoryClick = { story ->
                        viewModel.openStory(story)
                        navController.navigate("storyDetail/${story.id}")
                    },
                    onFavoriteToggle = { story ->
                        viewModel.toggleFavorite(story.id, story.isFavorite)
                    }
                )
            }

            composable(
                route = "storyDetail/{storyId}",
                arguments = listOf(navArgument("storyId") { type = NavType.StringType })
            ) { backStackEntry ->
                val storyId = backStackEntry.arguments?.getString("storyId")
                val story = allStories.find { it.id == storyId }

                if (story != null) {
                    StoryDetailScreen(
                        story = story,
                        onBackClick = { navController.popBackStack() },
                        onStartReading = {
                            viewModel.openStory(story)
                            navController.navigate("storyReader/${story.id}")
                        },
                        onStartListening = {
                            viewModel.openStory(story)
                            viewModel.toggleAudioNarration()
                            navController.navigate("storyReader/${story.id}")
                        },
                        onFavoriteToggle = {
                            viewModel.toggleFavorite(story.id, story.isFavorite)
                        }
                    )
                }
            }

            composable(
                route = "storyReader/{storyId}",
                arguments = listOf(navArgument("storyId") { type = NavType.StringType })
            ) { backStackEntry ->
                val storyId = backStackEntry.arguments?.getString("storyId")
                val story = activeStory ?: allStories.find { it.id == storyId }

                if (story != null) {
                    StoryReaderScreen(
                        story = story,
                        currentPageIndex = currentPageIndex,
                        isAudioPlaying = isAudioPlaying,
                        isNightMode = isNightMode,
                        fontSizeScale = fontSizeScale,
                        onNextPage = { viewModel.nextPage() },
                        onPreviousPage = { viewModel.previousPage() },
                        onChoiceClick = { targetPage -> viewModel.goToPage(targetPage - 1) },
                        onToggleAudio = { viewModel.toggleAudioNarration() },
                        onToggleNightMode = { viewModel.toggleNightMode() },
                        onChangeFontSize = { scale -> viewModel.setFontSizeScale(scale) },
                        onBackClick = { navController.popBackStack() },
                        onStoryFinished = {
                            navController.navigate("storyAfterthought/${story.id}") {
                                popUpTo("storyDetail/${story.id}") { inclusive = true }
                            }
                        }
                    )
                }
            }

            composable(
                route = "storyAfterthought/{storyId}",
                arguments = listOf(navArgument("storyId") { type = NavType.StringType })
            ) { backStackEntry ->
                val storyId = backStackEntry.arguments?.getString("storyId")
                val story = allStories.find { it.id == storyId }

                if (story != null) {
                    StoryAfterthoughtScreen(
                        story = story,
                        onReplayStory = {
                            viewModel.openStory(story)
                            navController.navigate("storyReader/${story.id}") {
                                popUpTo("storyAfterthought/${story.id}") { inclusive = true }
                            }
                        },
                        onGoHome = {
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Home.route) { inclusive = true }
                            }
                        }
                    )
                }
            }
        }
    }
}
