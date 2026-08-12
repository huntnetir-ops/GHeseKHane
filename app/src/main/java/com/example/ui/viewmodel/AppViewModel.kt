package com.example.ui.viewmodel

import android.app.Application
import android.speech.tts.TextToSpeech
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.AppDatabase
import com.example.data.local.SampleData
import com.example.data.model.Achievement
import com.example.data.model.ChildAchievement
import com.example.data.model.ChildProfile
import com.example.data.model.MiniGame
import com.example.data.model.ReadingProgress
import com.example.data.model.Story
import com.example.data.model.WorldFact
import com.example.data.repository.AchievementRepository
import com.example.data.repository.ProfileRepository
import com.example.data.repository.StoryRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Locale

class AppViewModel(application: Application) : AndroidViewModel(application), TextToSpeech.OnInitListener {

    private val database = AppDatabase.getInstance(application)
    private val storyRepo = StoryRepository(database.storyDao(), database.progressDao())
    private val profileRepo = ProfileRepository(database.profileDao())
    private val achievementRepo = AchievementRepository(database.achievementDao())

    // TTS engine for offline Persian / English narration
    private var tts: TextToSpeech? = TextToSpeech(application, this)
    private var isTtsReady = false

    // State Flows
    val currentProfile: StateFlow<ChildProfile?> = profileRepo.currentProfile.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = null
    )

    val allProfiles: StateFlow<List<ChildProfile>> = profileRepo.allProfiles.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val allStories: StateFlow<List<Story>> = storyRepo.allStories.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val favoriteStories: StateFlow<List<Story>> = storyRepo.favoriteStories.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val bedtimeStories: StateFlow<List<Story>> = storyRepo.bedtimeStories.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategoryId = MutableStateFlow("cat_all")
    val selectedCategoryId: StateFlow<String> = _selectedCategoryId.asStateFlow()

    private val _selectedAgeGroup = MutableStateFlow<String?>(null)
    val selectedAgeGroup: StateFlow<String?> = _selectedAgeGroup.asStateFlow()

    private val _isNightMode = MutableStateFlow(false)
    val isNightMode: StateFlow<Boolean> = _isNightMode.asStateFlow()

    private val _themeMode = MutableStateFlow("brand_custom") // "brand_custom", "system", "light", "dark"
    val themeMode: StateFlow<String> = _themeMode.asStateFlow()

    private val _fontSizeScale = MutableStateFlow(1.0f) // 0.85f, 1.0f, 1.25f, 1.5f
    val fontSizeScale: StateFlow<Float> = _fontSizeScale.asStateFlow()

    private val _narrationSpeed = MutableStateFlow(1.0f) // 0.75f, 1.0f, 1.25f, 1.5f
    val narrationSpeed: StateFlow<Float> = _narrationSpeed.asStateFlow()

    private val _ambientSound = MutableStateFlow("none") // "none", "rain", "lullaby", "forest"
    val ambientSound: StateFlow<String> = _ambientSound.asStateFlow()

    private val _autoAdvancePage = MutableStateFlow(true)
    val autoAdvancePage: StateFlow<Boolean> = _autoAdvancePage.asStateFlow()

    private val _highlightSentence = MutableStateFlow(true)
    val highlightSentence: StateFlow<Boolean> = _highlightSentence.asStateFlow()

    private val _dailyLimitMinutes = MutableStateFlow<Int?>(30)
    val dailyLimitMinutes: StateFlow<Int?> = _dailyLimitMinutes.asStateFlow()

    private val _bedtimeReminderTime = MutableStateFlow<String?>("21:00")
    val bedtimeReminderTime: StateFlow<String?> = _bedtimeReminderTime.asStateFlow()

    // Story Reader State
    private val _activeStory = MutableStateFlow<Story?>(null)
    val activeStory: StateFlow<Story?> = _activeStory.asStateFlow()

    private val _currentPageIndex = MutableStateFlow(0)
    val currentPageIndex: StateFlow<Int> = _currentPageIndex.asStateFlow()

    private val _isAudioPlaying = MutableStateFlow(false)
    val isAudioPlaying: StateFlow<Boolean> = _isAudioPlaying.asStateFlow()

    private val _highlightedSentenceIndex = MutableStateFlow(0)
    val highlightedSentenceIndex: StateFlow<Int> = _highlightedSentenceIndex.asStateFlow()

    // Sleep Timer
    private val _sleepTimerMinutes = MutableStateFlow<Int?>(null)
    val sleepTimerMinutes: StateFlow<Int?> = _sleepTimerMinutes.asStateFlow()
    private var sleepTimerJob: Job? = null

    // Achievements & Streak
    val earnedAchievements: StateFlow<List<ChildAchievement>> = combine(
        currentProfile,
        achievementRepo.allAchievements
    ) { profile, _ ->
        if (profile != null) {
            achievementRepo.getEarnedAchievements(profile.id).first()
        } else {
            emptyList()
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    val allAchievements: StateFlow<List<Achievement>> = achievementRepo.allAchievements.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _readingStreakDays = MutableStateFlow(3) // 3-day streak demo
    val readingStreakDays: StateFlow<Int> = _readingStreakDays.asStateFlow()

    // Parent Zone
    private val _parentPin = MutableStateFlow("1234")
    val parentPin: StateFlow<String> = _parentPin.asStateFlow()

    private val _isParentUnlocked = MutableStateFlow(false)
    val isParentUnlocked: StateFlow<Boolean> = _isParentUnlocked.asStateFlow()

    // Facts & Mini games
    val worldFacts: List<WorldFact> = SampleData.worldFacts
    val miniGames: List<MiniGame> = SampleData.miniGames

    init {
        viewModelScope.launch {
            storyRepo.seedStoriesIfEmpty()
            achievementRepo.seedAchievementsIfEmpty()
            val profile = profileRepo.getCurrentProfileDirect()
            if (profile == null) {
                // Pre-create default profile if empty
                profileRepo.createProfile("سامان", 7, "avatar_owl", listOf("فضا", "حیوانات"))
            }
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale("fa"))
            isTtsReady = result != TextToSpeech.LANG_MISSING_DATA && result != TextToSpeech.LANG_NOT_SUPPORTED
        }
    }

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setCategoryFilter(catId: String) {
        _selectedCategoryId.value = catId
    }

    fun setAgeGroupFilter(age: String?) {
        _selectedAgeGroup.value = age
    }

    fun toggleNightMode() {
        _isNightMode.value = !_isNightMode.value
        _themeMode.value = if (_isNightMode.value) "dark" else "brand_custom"
    }

    fun setThemeMode(mode: String) {
        _themeMode.value = mode
        _isNightMode.value = (mode == "dark")
    }

    fun setFontSizeScale(scale: Float) {
        _fontSizeScale.value = scale
    }

    fun setNarrationSpeed(speed: Float) {
        _narrationSpeed.value = speed
        if (isTtsReady && tts != null) {
            tts?.setSpeechRate(speed)
        }
    }

    fun setAmbientSound(sound: String) {
        _ambientSound.value = sound
    }

    fun toggleAutoAdvancePage() {
        _autoAdvancePage.value = !_autoAdvancePage.value
    }

    fun toggleHighlightSentence() {
        _highlightSentence.value = !_highlightSentence.value
    }

    fun setDailyLimitMinutes(mins: Int?) {
        _dailyLimitMinutes.value = mins
    }

    fun setBedtimeReminderTime(time: String?) {
        _bedtimeReminderTime.value = time
    }

    fun changeParentPin(newPin: String) {
        _parentPin.value = newPin
    }

    fun resetProgressData() {
        viewModelScope.launch {
            val stories = database.storyDao().getAllStories().first()
            stories.forEach { story ->
                database.storyDao().updateCompleted(story.id, false)
                database.storyDao().updateFavorite(story.id, false)
            }
        }
    }

    fun createProfile(name: String, age: Int, avatarId: String, interests: List<String>) {
        viewModelScope.launch {
            profileRepo.createProfile(name, age, avatarId, interests)
        }
    }

    fun selectProfile(profileId: Long) {
        viewModelScope.launch {
            profileRepo.selectProfile(profileId)
        }
    }

    fun toggleFavorite(storyId: String, currentFav: Boolean) {
        viewModelScope.launch {
            storyRepo.toggleFavorite(storyId, currentFav)
        }
    }

    fun openStory(story: Story) {
        _activeStory.value = story
        _currentPageIndex.value = 0
        _isAudioPlaying.value = false
        stopAudioNarration()
    }

    fun nextPage() {
        val story = _activeStory.value ?: return
        if (_currentPageIndex.value < story.pages.size - 1) {
            _currentPageIndex.value += 1
            saveProgress()
            if (_isAudioPlaying.value) {
                playCurrentPageAudio()
            }
        } else {
            // Story Completed!
            markStoryCompleted()
        }
    }

    fun previousPage() {
        if (_currentPageIndex.value > 0) {
            _currentPageIndex.value -= 1
            saveProgress()
            if (_isAudioPlaying.value) {
                playCurrentPageAudio()
            }
        }
    }

    fun goToPage(pageIndex: Int) {
        val story = _activeStory.value ?: return
        if (pageIndex in story.pages.indices) {
            _currentPageIndex.value = pageIndex
            saveProgress()
            if (_isAudioPlaying.value) {
                playCurrentPageAudio()
            }
        }
    }

    private fun saveProgress() {
        val story = _activeStory.value ?: return
        val profile = currentProfile.value ?: return
        viewModelScope.launch {
            storyRepo.saveReadingProgress(
                childId = profile.id,
                storyId = story.id,
                page = _currentPageIndex.value + 1,
                totalPages = story.pages.size
            )
        }
    }

    private fun markStoryCompleted() {
        val story = _activeStory.value ?: return
        val profile = currentProfile.value ?: return
        viewModelScope.launch {
            storyRepo.markStoryCompleted(story.id)
            val completedCount = database.storyDao().getAllStories().first().count { it.isCompleted }
            achievementRepo.checkAndUnlockAchievements(profile.id, completedCount)
        }
    }

    fun toggleAudioNarration() {
        if (_isAudioPlaying.value) {
            stopAudioNarration()
        } else {
            playCurrentPageAudio()
        }
    }

    private fun playCurrentPageAudio() {
        val story = _activeStory.value ?: return
        val page = story.pages.getOrNull(_currentPageIndex.value) ?: return
        _isAudioPlaying.value = true

        if (isTtsReady && tts != null) {
            tts?.speak(page.text, TextToSpeech.QUEUE_FLUSH, null, "page_ narration")
        }

        // Simulate sentence highlight timer
        viewModelScope.launch {
            val sentences = page.text.split("؛", ".", "!")
            for (i in sentences.indices) {
                if (!_isAudioPlaying.value) break
                _highlightedSentenceIndex.value = i
                delay(2500)
            }
        }
    }

    fun stopAudioNarration() {
        _isAudioPlaying.value = false
        if (isTtsReady) {
            tts?.stop()
        }
    }

    fun setSleepTimer(minutes: Int) {
        _sleepTimerMinutes.value = minutes
        sleepTimerJob?.cancel()
        sleepTimerJob = viewModelScope.launch {
            while ((_sleepTimerMinutes.value ?: 0) > 0) {
                delay(60000)
                _sleepTimerMinutes.value = (_sleepTimerMinutes.value ?: 1) - 1
            }
            // Sleep timer expired
            stopAudioNarration()
            _isNightMode.value = true
        }
    }

    fun cancelSleepTimer() {
        sleepTimerJob?.cancel()
        _sleepTimerMinutes.value = null
    }

    fun verifyParentPin(pin: String): Boolean {
        return if (pin == _parentPin.value) {
            _isParentUnlocked.value = true
            true
        } else {
            false
        }
    }

    fun lockParentZone() {
        _isParentUnlocked.value = false
    }

    override fun onCleared() {
        super.onCleared()
        tts?.shutdown()
        sleepTimerJob?.cancel()
    }
}
