package com.dsc.myliving.presentation.features.entry.signin.state

import androidx.compose.runtime.*

class TextFieldState(val label: String) {
    var value: String by mutableStateOf("")
    val onValueChange: (t: String) -> Unit = { value = it }

    fun validate() {

    }
}

@Composable
fun rememberTextFieldState(label: String) = remember {
    TextFieldState(label = label)
}