package com.example.data.repository

import com.example.data.local.AchievementDao
import com.example.data.local.ProfileDao
import com.example.data.local.ProgressDao
import com.example.data.local.SampleData
import com.example.data.local.StoryDao
import com.example.data.model.Achievement
import com.example.data.model.ChildAchievement
import com.example.data.model.ChildProfile
import com.example.data.model.ReadingProgress
import com.example.data.model.Story
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first

class StoryRepository(
    private val storyDao: StoryDao,
    private val progressDao: ProgressDao
) {
    val allStories: Flow<List<Story>> = storyDao.getAllStories()
    val favoriteStories: Flow<List<Story>> = storyDao.getFavoriteStories()
    val bedtimeStories: Flow<List<Story>> = storyDao.getBedtimeStories()

    suspend fun seedStoriesIfEmpty() {
        val existing = storyDao.getAllStories().first()
        if (existing.size < SampleData.stories.size) {
            storyDao.insertStories(SampleData.stories)
        }
    }

    fun getStoryById(id: String): Flow<Story?> = storyDao.getStoryById(id)

    fun getStoriesByCategory(categoryId: String): Flow<List<Story>> =
        storyDao.getStoriesByCategory(categoryId)

    suspend fun toggleFavorite(storyId: String, currentFavState: Boolean) {
        storyDao.updateFavorite(storyId, !currentFavState)
    }

    suspend fun markStoryCompleted(storyId: String) {
        storyDao.updateCompleted(storyId, true)
    }

    suspend fun saveReadingProgress(childId: Long, storyId: String, page: Int, totalPages: Int) {
        val isCompleted = page >= totalPages
        val progress = ReadingProgress(
            id = "${childId}_${storyId}",
            childId = childId,
            storyId = storyId,
            currentPage = page,
            totalPages = totalPages,
            isCompleted = isCompleted
        )
        progressDao.saveProgress(progress)
        if (isCompleted) {
            storyDao.updateCompleted(storyId, true)
        }
    }

    fun getProgressForChild(childId: Long): Flow<List<ReadingProgress>> =
        progressDao.getProgressForChild(childId)

    fun getCompletedCount(childId: Long): Flow<Int> =
        progressDao.getCompletedCount(childId)
}

class ProfileRepository(private val profileDao: ProfileDao) {
    val allProfiles: Flow<List<ChildProfile>> = profileDao.getAllProfiles()
    val currentProfile: Flow<ChildProfile?> = profileDao.getCurrentProfile()

    suspend fun createProfile(name: String, age: Int, avatarId: String, interests: List<String>): Long {
        profileDao.clearCurrentProfiles()
        val newProfile = ChildProfile(
            name = name,
            age = age,
            avatarId = avatarId,
            interests = interests,
            isCurrent = true
        )
        return profileDao.insertProfile(newProfile)
    }

    suspend fun selectProfile(profileId: Long) {
        profileDao.clearCurrentProfiles()
        profileDao.setCurrentProfile(profileId)
    }

    suspend fun getCurrentProfileDirect(): ChildProfile? = profileDao.getCurrentProfileDirect()
}

class AchievementRepository(private val achievementDao: AchievementDao) {
    val allAchievements: Flow<List<Achievement>> = achievementDao.getAllAchievements()

    fun getEarnedAchievements(childId: Long): Flow<List<ChildAchievement>> =
        achievementDao.getEarnedAchievements(childId)

    suspend fun seedAchievementsIfEmpty() {
        val existing = achievementDao.getAllAchievements().first()
        if (existing.isEmpty()) {
            achievementDao.insertAchievements(SampleData.defaultAchievements)
        }
    }

    suspend fun checkAndUnlockAchievements(childId: Long, completedCount: Int) {
        val achievements = achievementDao.getAllAchievements().first()
        val earned = achievementDao.getEarnedAchievements(childId).first().map { it.achievementId }

        achievements.forEach { ach ->
            if (!earned.contains(ach.id) && completedCount >= ach.requiredCount) {
                achievementDao.unlockAchievement(
                    ChildAchievement(childId = childId, achievementId = ach.id)
                )
            }
        }
    }
}
