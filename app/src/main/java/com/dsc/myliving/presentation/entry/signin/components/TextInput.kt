package com.dsc.myliving.presentation.entry.signin.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dsc.myliving.presentation.entry.signin.state.TextFieldState
import com.dsc.myliving.presentation.entry.signin.state.rememberTextFieldState

@Composable
fun TextInput(textFieldState: TextFieldState) {
    OutlinedTextField(value = textFieldState.value, onValueChange = textFieldState.onValueChange)
}

@Preview
@Composable
fun TextInputPreview() {
    TextInput(textFieldState = rememberTextFieldState())
}