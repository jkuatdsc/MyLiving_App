package com.dsc.myliving.presentation.components

import android.util.Patterns
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dsc.myliving.presentation.theme.shapes

class EntryTextInput(private vararg val validators: Validators) {

    private var text by mutableStateOf("")
    private var showError by mutableStateOf(false)
    private var errorMessage by mutableStateOf("")

    @Composable
    fun Content(@StringRes label: Int) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = label))
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.fillMaxWidth(),
                shape = shapes.small,
                maxLines = 1,
                singleLine = true,
                isError = showError,
                colors = TextFieldDefaults.outlinedTextFieldColors(textColor = MaterialTheme.colors.onSecondary)
            )
            if (showError) Text(
                text = errorMessage,
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.error
            )
        }
    }

    fun validate(): Boolean {
        return validators.map { validator ->
            when (validator) {
                is Validators.Required -> {
                    showError = !required()
                    errorMessage = validator.message
                    required()
                }
                is Validators.Email -> {
                    errorMessage = validator.message
                    showError = !email()
                    email()
                }
                is Validators.Min -> {
                    errorMessage = validator.message
                    showError = !min(validator.limit)
                    min(validator.limit)
                }
                is Validators.Max -> {
                    errorMessage = validator.message
                    showError = !max(validator.limit)
                    max(validator.limit)
                }
            }
        }.all { it }
    }


    private fun required(): Boolean {
        if (text == "") return false
        return true
    }

    private fun email(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(text).matches()
    }

    private fun min(limit: Int): Boolean {
        return text.length > limit
    }

    private fun max(limit: Int): Boolean {
        return text.length < limit
    }

}

