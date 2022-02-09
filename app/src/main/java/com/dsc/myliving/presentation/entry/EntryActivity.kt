package com.dsc.myliving.presentation.entry

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.dsc.myliving.presentation.intro.IntroActivity
import com.dsc.myliving.presentation.theme.MyLivingTheme
import com.dsc.myliving.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class EntryActivity : ComponentActivity() {

    @Inject lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        // TODO: redirect to auth if token exists
        val token = preferences.getToken()
        val activity = when {
            token != null -> IntroActivity::class.java
            else -> IntroActivity::class.java
        }
        val intent = Intent(this, activity)
        startActivity(intent)
        finish()

    }
}