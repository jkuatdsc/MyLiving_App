package com.dsc.myliving.presentation.features.auth

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dsc.form_builder.FormState
import com.dsc.form_builder.TextFieldState
import com.dsc.form_builder.Validators
import java.util.*

class AuthViewmodel : ViewModel() {

    var current by mutableStateOf(0)

    val loginFormState: FormState = FormState(
        fields = listOf(
            TextFieldState(
                name = "email",
                validators = listOf(Validators.Email()),
                transform = { it.trim().lowercase(Locale.getDefault()) }
            ),
            TextFieldState(
                name = "password",
                validators = listOf(Validators.MinChars(8, message = "password is too short"))
            )
        )
    )
    val signupFormState = FormState(
        fields = listOf(
            TextFieldState(
                name = "email",
                validators = listOf(Validators.Email()),
                transform = { it.trim().lowercase(Locale.getDefault()) }
            ),
            TextFieldState(
                name = "password",
                validators = listOf(Validators.MinChars(8, message = "password is too short"))
            ),
            TextFieldState(name = "confirm")
        )
    )

    fun login() {
        if (loginFormState.validate()){
            // TODO: authenticate the user
            Log.d("Login", "login: we are good to go")
        }
    }

    fun signup(){
        if (signupFormState.validate()){
            val confirmState = signupFormState.getState("confirm")
            val password = signupFormState.getState("password").text

            if (confirmState.text != password){
                confirmState.showError("passwords do not match")
                return
            }

            // TODO: register user
            Log.d("Signup", "signup: we are good to go")
        }
    }
}