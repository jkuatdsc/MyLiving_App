package com.dsc.myliving.presentation.components.form

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dsc.myliving.presentation.components.form.Validators.*

open class TextFieldState<T>(
    initial: String = "",
    val name: String = "",
    val onChanged: (String) -> Unit = {},
    val transform: ((String) -> T)? = null,
    val validators: List<Validators> = listOf(),
){

    var text: String by mutableStateOf(initial)
    var message: String by mutableStateOf("")
    var hasError: Boolean by mutableStateOf(false)

    fun change(value: String){
        hideError()
        text = value
        onChanged(value)
    }

    fun showError(error: String){
        hasError = true
        message = error
    }

    fun hideError(){
        message = ""
        hasError = false
    }

    fun validate(): Boolean {
        val validations =  validators.map {
            when (it){
                is Email -> validateEmail(it.message)
                is Required -> validateRequired(it.message)
                is MinChars -> validateMinChars(it.limit, it.message)
                is MaxChars -> validateMaxChars(it.limit, it.message)
            }
        }
        return validations.all { it }
    }

    private fun validateMaxChars(limit: Int, message: String): Boolean {
        val valid = text.length <= limit
        if (!valid) showError(message)
        return valid
    }

    private fun validateMinChars(limit: Int, message: String): Boolean {
        val valid = text.length >= limit
        if (!valid) showError(message)
        return valid
    }

    private fun validateEmail(message: String): Boolean {
        val valid = Patterns.EMAIL_ADDRESS.matcher(text).matches()
        if (!valid) showError(message)
        return valid
    }

    private fun validateRequired(message: String): Boolean {
        val valid = text.isNotEmpty()
        if (!valid) showError(message)
        return valid
    }
}

