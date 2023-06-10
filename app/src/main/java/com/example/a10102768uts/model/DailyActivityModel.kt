package com.example.a10102768uts.model

class DailyActivityModel {
    private val activities = mutableListOf<DailyActivity>()

    fun addActivity(title: String, imageRes: Int, description: String) {
        activities.add(DailyActivity(title, imageRes, description))
    }

    fun getActivities(): List<DailyActivity> {
        return activities
    }
}
data class DailyActivity(val title: String, val imageResId: Int, val description: String)