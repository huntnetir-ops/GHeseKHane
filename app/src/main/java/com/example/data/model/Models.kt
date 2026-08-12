package com.example.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@Entity(tableName = "child_profiles")
data class ChildProfile(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val age: Int,
    val avatarId: String = "avatar_1",
    val interests: List<String> = emptyList(),
    val isCurrent: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "stories")
data class Story(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val ageGroup: String, // "3-5", "6-8", "9-12", "13+"
    val categoryId: String,
    val categoryName: String,
    val coverDrawable: String = "img_hero",
    val estimatedReadingTime: Int, // minutes
    val hasAudio: Boolean = true,
    val author: String = "قصهخانه",
    val tags: List<String> = emptyList(),
    val moralLesson: String,
    val isBedtimeStory: Boolean = false,
    val pages: List<StoryPage> = emptyList(),
    val isFavorite: Boolean = false,
    val isCompleted: Boolean = false
)

data class StoryPage(
    val pageNumber: Int,
    val text: String,
    val illustrationName: String = "",
    val choices: List<StoryChoice> = emptyList(), // For interactive branching stories
    val targetPageIfChosen: Int? = null
)

data class StoryChoice(
    val optionText: String,
    val targetPageNumber: Int,
    val moralNote: String = ""
)

@Entity(tableName = "reading_progress")
data class ReadingProgress(
    @PrimaryKey val id: String, // "${childId}_${storyId}"
    val childId: Long,
    val storyId: String,
    val currentPage: Int,
    val totalPages: Int,
    val isCompleted: Boolean,
    val lastReadAt: Long = System.currentTimeMillis()
)

@Entity(tableName = "achievements")
data class Achievement(
    @PrimaryKey val id: String,
    val title: String,
    val description: String,
    val iconName: String, // e.g. "star", "book", "owl"
    val requiredCount: Int = 1
)

@Entity(tableName = "child_achievements")
data class ChildAchievement(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val childId: Long,
    val achievementId: String,
    val earnedAt: Long = System.currentTimeMillis()
)

data class StoryCategory(
    val id: String,
    val title: String,
    val iconName: String,
    val colorHex: String
)

data class WorldFact(
    val id: String,
    val category: String, // "حیوانات", "فضا", "فرهنگها", "اختراعات", "مشاغل"
    val title: String,
    val content: String,
    val funFact: String,
    val icon: String
)

data class MiniGame(
    val id: String,
    val title: String,
    val type: String, // "MEMORY", "QUIZ", "MATCH"
    val description: String,
    val icon: String
)

class Converters {
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @TypeConverter
    fun fromListString(value: List<String>): String {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        return moshi.adapter<List<String>>(type).toJson(value)
    }

    @TypeConverter
    fun toListString(value: String): List<String> {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        return moshi.adapter<List<String>>(type).fromJson(value) ?: emptyList()
    }

    @TypeConverter
    fun fromStoryPages(value: List<StoryPage>): String {
        val type = Types.newParameterizedType(List::class.java, StoryPage::class.java)
        return moshi.adapter<List<StoryPage>>(type).toJson(value)
    }

    @TypeConverter
    fun toStoryPages(value: String): List<StoryPage> {
        val type = Types.newParameterizedType(List::class.java, StoryPage::class.java)
        return moshi.adapter<List<StoryPage>>(type).fromJson(value) ?: emptyList()
    }
}
