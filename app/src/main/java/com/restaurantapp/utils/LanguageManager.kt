package com.restaurantapp.utils

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*

object LanguageManager {
    private const val LANGUAGE_PREFERENCE = "language_preference"
    private const val LANGUAGE_KEY = "selected_language"

    fun setLanguage(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)

        context.resources.updateConfiguration(config, context.resources.displayMetrics)

        // Save language preference
        val prefs = context.getSharedPreferences(LANGUAGE_PREFERENCE, Context.MODE_PRIVATE)
        prefs.edit().putString(LANGUAGE_KEY, languageCode).apply()
    }

    fun getCurrentLanguage(context: Context): String {
        val prefs = context.getSharedPreferences(LANGUAGE_PREFERENCE, Context.MODE_PRIVATE)
        return prefs.getString(LANGUAGE_KEY, "en") ?: "en"
    }

    fun getSupportedLanguages(): List<Language> {
        return listOf(
            Language("en", "English", "🇺🇸"),
            Language("es", "Español", "🇪🇸"),
            Language("fr", "Français", "🇫🇷")
        )
    }

    data class Language(
        val code: String,
        val name: String,
        val flag: String
    )
}
