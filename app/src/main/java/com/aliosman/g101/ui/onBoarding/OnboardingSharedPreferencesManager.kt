package com.aliosman.g101.ui.onBoarding

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

internal class OnboardingSharedPreferencesManager(context: Context) {

    private val prefName = "ONBOARDING_PREF"
    private val prefKey = "ONBOARDING_COMPLETED"
    val onboarding: SharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)

    // İlk girişin varlığını kontrol et
    fun isOnboardingCompleted(): Boolean {
        return onboarding.getBoolean(prefKey, false)
    }

    // İlk girişten sonra 1 koy
    fun markOnboardingCompleted() {
        onboarding.edit { putBoolean(prefKey, true) }
    }
}