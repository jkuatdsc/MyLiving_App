package com.dsc.myliving.presentation.features.entry

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.dsc.myliving.presentation.features.intro.IntroActivity
import com.dsc.myliving.presentation.features.main.MainActivity
import com.dsc.myliving.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EntryActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        val token = preferences.getToken()
        val activity = when {
            token != null -> MainActivity::class.java
            else -> IntroActivity::class.java
        }
        val intent = Intent(this, activity)
        startActivity(intent)
        finish()
    }
}