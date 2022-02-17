package com.dsc.myliving.presentation.features.auth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import com.dsc.myliving.presentation.features.auth.screens.Login
import com.dsc.myliving.presentation.features.auth.screens.Signup
import com.dsc.myliving.presentation.theme.MyLivingTheme

class AuthActivity : ComponentActivity() {
    private val viewModel: AuthViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLivingTheme {
                Surface {
                    when (viewModel.current) {
                        0 -> Login()
                        else -> Signup()
                    }
                }
            }
        }
    }
}