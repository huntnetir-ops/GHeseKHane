package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.model.Achievement
import com.example.data.model.ChildAchievement
import com.example.data.model.ChildProfile
import com.example.data.model.Converters
import com.example.data.model.ReadingProgress
import com.example.data.model.Story

@Database(
    entities = [
        ChildProfile::class,
        Story::class,
        ReadingProgress::class,
        Achievement::class,
        ChildAchievement::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun profileDao(): ProfileDao
    abstract fun storyDao(): StoryDao
    abstract fun progressDao(): ProgressDao
    abstract fun achievementDao(): AchievementDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "qesseh_khaneh.db"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
