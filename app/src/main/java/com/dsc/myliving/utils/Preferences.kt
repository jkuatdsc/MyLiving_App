package com.dsc.myliving.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Preferences @Inject constructor(@ApplicationContext context: Context) {
    private val tokenKey = "ACCESS_TOKEN"
    private val introKey = "INTRO_SCREEN"
    private val preferences = context.getSharedPreferences("MY_LIVING_PREFS", Context.MODE_PRIVATE)

    fun getToken() = preferences.getString(tokenKey, null)

    fun getIntro() = preferences.getBoolean(introKey, false)

    fun setToken(token: String) = preferences.set(tokenKey, token)

    fun setIntro(finished: Boolean) = preferences.set(introKey, finished)

    operator fun SharedPreferences.set(key: String, value: Any?){
        when (value) {
            is Int -> edit { this.putInt(key, value) }
            is Long -> edit { this.putLong(key, value) }
            is Float -> edit { this.putFloat(key, value) }
            is String? -> edit { this.putString(key, value) }
            is Boolean -> edit { this.putBoolean(key, value) }
            else -> throw UnsupportedOperationException("Not yet implemented")
        }
    }
}