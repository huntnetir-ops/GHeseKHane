package com.example.util

import com.example.data.model.ChildProfile
import com.example.data.model.Story

data class DanaChatMessage(
    val id: String = java.util.UUID.randomUUID().toString(),
    val sender: String, // "DANA" or "USER"
    val text: String,
    val recommendedStories: List<Story> = emptyList(),
    val timestamp: Long = System.currentTimeMillis()
)

data class DanaRecommendationResult(
    val explanationText: String,
    val recommendedStories: List<Story>
)

object DanaAssistantEngine {

    // Preset Quick Suggestion Prompts for Children & Parents
    val quickPrompts = listOf(
        "🌙 یک قصه خواب‌آور و آرامش‌بخش برام پیدا کن",
        "🦊 یک داستان قشنگ درباره حیوانات و جنگل",
        "🚀 داستان علمی، فضا یا ربات‌های جالب",
        "👑 قصه شاهنامه، افسانه و قهرمانان ایرانی",
        "💖 داستان کوتاه درباره دوست‌یابی و مهربانی",
        "🎯 بهترین پیشنهاد بر اساس سن و علایق من"
    )

    fun processQuery(
        query: String,
        allStories: List<Story>,
        profile: ChildProfile?,
        readStoryIds: Set<String> = emptySet(),
        favoriteStoryIds: Set<String> = emptySet()
    ): DanaRecommendationResult {
        val childName = profile?.name ?: "دوست کوچولو"
        val childAge = profile?.age ?: 6
        val childInterests = profile?.interests ?: emptyList()

        if (allStories.isEmpty()) {
            return DanaRecommendationResult(
                explanationText = "سلام $childName عزیز! متأسفانه هنوز داستانی در کتابخانه ثبت نشده است.",
                recommendedStories = emptyList()
            )
        }

        val normalizedQuery = query.lowercase().trim()

        // Compute Match Scores for each Story
        val scoredStories = allStories.map { story ->
            var score = 0.0

            // 1. Keyword Vector / Similarity Matching with Query
            val textContent = "${story.title} ${story.description} ${story.categoryName} ${story.moralLesson}".lowercase()
            
            // Intent checks
            val isBedtimeQuery = normalizedQuery.contains("خواب") || normalizedQuery.contains("شب") || normalizedQuery.contains("لالایی") || normalizedQuery.contains("آرامش")
            val isAnimalQuery = normalizedQuery.contains("حیوان") || normalizedQuery.contains("جنگل") || normalizedQuery.contains("طبیعت") || normalizedQuery.contains("درخت")
            val isScienceQuery = normalizedQuery.contains("علم") || normalizedQuery.contains("فضا") || normalizedQuery.contains("ربات") || normalizedQuery.contains("اختراع") || normalizedQuery.contains("کهکشان")
            val isMythQuery = normalizedQuery.contains("شاهنامه") || normalizedQuery.contains("افسانه") || normalizedQuery.contains("قهرمان") || normalizedQuery.contains("سیمرغ") || normalizedQuery.contains("جادو") || normalizedQuery.contains("فانتزی")
            val isKindnessQuery = normalizedQuery.contains("دوست") || normalizedQuery.contains("مهربان") || normalizedQuery.contains("خانواده") || normalizedQuery.contains("مدرسه") || normalizedQuery.contains("بخشش")
            val isShortQuery = normalizedQuery.contains("کوتاه") || normalizedQuery.contains("سریع") || normalizedQuery.contains("کم")

            if (isBedtimeQuery && story.isBedtimeStory) score += 25.0
            if (isBedtimeQuery && story.categoryId == "cat_bedtime") score += 20.0

            if (isAnimalQuery && (story.categoryId == "cat_animals" || story.categoryId == "cat_nature")) score += 20.0
            if (isScienceQuery && (story.categoryId == "cat_science" || story.categoryId == "cat_space")) score += 20.0
            if (isMythQuery && story.categoryId == "cat_fantasy") score += 20.0
            if (isKindnessQuery && (story.categoryId == "cat_family" || story.categoryId == "cat_school")) score += 20.0

            if (isShortQuery && story.estimatedReadingTime <= 3) score += 15.0

            // Direct word overlap
            val queryWords = normalizedQuery.split(Regex("\\s+")).filter { it.length > 2 }
            for (word in queryWords) {
                if (textContent.contains(word)) {
                    score += 10.0
                }
            }

            // 2. Profile Age Fit Score
            val (minAge, maxAge) = parseAgeGroup(story.ageGroup)
            if (childAge in minAge..maxAge) {
                score += 15.0
            } else if (kotlin.math.abs(childAge - minAge) <= 2) {
                score += 8.0
            }

            // 3. Profile Interests Fit Score
            for (interest in childInterests) {
                if (textContent.contains(interest.lowercase())) {
                    score += 12.0
                }
            }

            // 4. History Novelty & Favorite Boost
            if (favoriteStoryIds.contains(story.id)) {
                score += 10.0
            }
            if (!readStoryIds.contains(story.id)) {
                score += 12.0 // Boost unread stories for fresh discovery
            }

            story to score
        }

        // Sort by highest score
        val topStories = scoredStories
            .sortedByDescending { it.second }
            .take(3)
            .map { it.first }

        // Build Custom Natural Persian Response
        val explanation = buildString {
            append("سلام $childName عزیز! 🤖✨\n")
            append("من هوش دانای دانا هستم. دیتابیس داستان‌های برنامه رو بررسی کردم و بر اساس درخواستت: «$query» ")

            if (normalizedQuery.contains("خواب") || normalizedQuery.contains("شب")) {
                append("چند قصه آرامش‌بخش قبل از خواب رو برات آماده کردم تا با شنیدن اون‌ها خواب‌های شیرین ببینی:\n")
            } else if (normalizedQuery.contains("حیوان") || normalizedQuery.contains("جنگل")) {
                append("بهترین داستان‌های حیوانات مهربان و طبیعت شگفت‌انگیز رو برات انتخاب کردم:\n")
            } else if (normalizedQuery.contains("شاهنامه") || normalizedQuery.contains("افسانه")) {
                append("قصه‌های کهن، افسانه‌ای و پر از شجاعت ایران‌زمین رو برات آوردم:\n")
            } else if (normalizedQuery.contains("علم") || normalizedQuery.contains("فضا")) {
                append("داستان‌های علمی و ماجراجویی‌های کهکشانی جذاب زیر رو پیشنهاد می‌کنم:\n")
            } else {
                append("بهترین داستان‌های متناسب با سن ($childAge ساله) و علایقت رو برات آماده کردم:\n")
            }
        }

        return DanaRecommendationResult(
            explanationText = explanation,
            recommendedStories = topStories
        )
    }

    private fun parseAgeGroup(ageGroupStr: String): Pair<Int, Int> {
        val parts = ageGroupStr.split("-")
        if (parts.size == 2) {
            val min = parts[0].trim().toIntOrNull() ?: 3
            val max = parts[1].trim().toIntOrNull() ?: 12
            return Pair(min, max)
        }
        return Pair(3, 12)
    }
}
