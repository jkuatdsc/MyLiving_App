package com.dsc.myliving.presentation.components.form

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardOptions.Companion.Default
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Ascii
import androidx.compose.ui.text.input.KeyboardType.Companion.Password
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.dsc.myliving.presentation.theme.shapes
import com.dsc.myliving.presentation.theme.tinyVPadding

@Composable
fun TextInput(state: TextFieldState<*>, modifier: Modifier = Modifier, type: KeyboardType = Ascii){
    Column {
        OutlinedTextField(
            value = state.text,
            modifier = modifier,
            singleLine = true,
            shape = shapes.small,
            isError = state.hasError,
            onValueChange = { state.change(it) },
            keyboardOptions = Default.copy(keyboardType = type),
            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = colors.onSecondary),
        )
        if (state.hasError) {
            Text(state.message, color = colors.error, modifier = modifier.tinyVPadding())
        }
    }
}

@Composable
fun PasswordInput(state: TextFieldState<*>, modifier: Modifier = Modifier){
    var hidden by remember { mutableStateOf(true) }
    val icon = if (hidden) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
    val transformation = if (hidden)  PasswordVisualTransformation() else VisualTransformation.None

    Column {
        OutlinedTextField(
            value = state.text,
            modifier = modifier,
            singleLine = true,
            shape = shapes.small,
            isError = state.hasError,
            visualTransformation = transformation,
            onValueChange = { state.change(it) },
            keyboardOptions = Default.copy(keyboardType = Password),
            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = colors.onSecondary),
            trailingIcon = {
                when {
                    state.hasError -> Icon(imageVector = Icons.Filled.Error, contentDescription = "Error")
                    else -> IconButton(onClick = { hidden = !hidden }) {
                        Icon(imageVector  = icon, "visibility")
                    }
                }
            },
        )
        if (state.hasError) {
            Text(state.message, color = colors.error, modifier = modifier.tinyVPadding())
        }
    }
}