package com.dsc.myliving.presentation.features.signin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import com.dsc.myliving.presentation.features.signin.screens.SignIn
import com.dsc.myliving.presentation.features.signin.screens.SignUp
import com.dsc.myliving.presentation.theme.MyLivingTheme

class SignInActivity : ComponentActivity() {
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLivingTheme {
                Surface {
                    when (viewModel.current) {
                        0 -> SignIn()
                        else -> SignUp()
                    }
                }
            }
        }
    }
}