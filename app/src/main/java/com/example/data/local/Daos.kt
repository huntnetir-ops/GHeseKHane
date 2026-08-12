package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.data.model.Achievement
import com.example.data.model.ChildAchievement
import com.example.data.model.ChildProfile
import com.example.data.model.ReadingProgress
import com.example.data.model.Story
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {
    @Query("SELECT * FROM child_profiles ORDER BY id ASC")
    fun getAllProfiles(): Flow<List<ChildProfile>>

    @Query("SELECT * FROM child_profiles WHERE isCurrent = 1 LIMIT 1")
    fun getCurrentProfile(): Flow<ChildProfile?>

    @Query("SELECT * FROM child_profiles WHERE isCurrent = 1 LIMIT 1")
    suspend fun getCurrentProfileDirect(): ChildProfile?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfile(profile: ChildProfile): Long

    @Update
    suspend fun updateProfile(profile: ChildProfile)

    @Query("UPDATE child_profiles SET isCurrent = 0")
    suspend fun clearCurrentProfiles()

    @Query("UPDATE child_profiles SET isCurrent = 1 WHERE id = :profileId")
    suspend fun setCurrentProfile(profileId: Long)
}

@Dao
interface StoryDao {
    @Query("SELECT * FROM stories")
    fun getAllStories(): Flow<List<Story>>

    @Query("SELECT * FROM stories WHERE id = :id")
    fun getStoryById(id: String): Flow<Story?>

    @Query("SELECT * FROM stories WHERE isFavorite = 1")
    fun getFavoriteStories(): Flow<List<Story>>

    @Query("SELECT * FROM stories WHERE isBedtimeStory = 1")
    fun getBedtimeStories(): Flow<List<Story>>

    @Query("SELECT * FROM stories WHERE categoryId = :categoryId")
    fun getStoriesByCategory(categoryId: String): Flow<List<Story>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStories(stories: List<Story>)

    @Query("UPDATE stories SET isFavorite = :isFav WHERE id = :id")
    suspend fun updateFavorite(id: String, isFav: Boolean)

    @Query("UPDATE stories SET isCompleted = :isComp WHERE id = :id")
    suspend fun updateCompleted(id: String, isComp: Boolean)
}

@Dao
interface ProgressDao {
    @Query("SELECT * FROM reading_progress WHERE childId = :childId")
    fun getProgressForChild(childId: Long): Flow<List<ReadingProgress>>

    @Query("SELECT * FROM reading_progress WHERE childId = :childId AND storyId = :storyId LIMIT 1")
    suspend fun getProgressForStory(childId: Long, storyId: String): ReadingProgress?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProgress(progress: ReadingProgress)

    @Query("SELECT COUNT(*) FROM reading_progress WHERE childId = :childId AND isCompleted = 1")
    fun getCompletedCount(childId: Long): Flow<Int>
}

@Dao
interface AchievementDao {
    @Query("SELECT * FROM achievements")
    fun getAllAchievements(): Flow<List<Achievement>>

    @Query("SELECT * FROM child_achievements WHERE childId = :childId")
    fun getEarnedAchievements(childId: Long): Flow<List<ChildAchievement>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAchievements(achievements: List<Achievement>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun unlockAchievement(childAchievement: ChildAchievement)
}
