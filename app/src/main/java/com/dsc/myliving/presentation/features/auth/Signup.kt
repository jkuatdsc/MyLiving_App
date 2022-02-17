package com.dsc.myliving.presentation.features.auth.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dsc.myliving.R
import com.dsc.myliving.presentation.components.EntryButton
import com.dsc.myliving.presentation.components.form.PasswordInput
import com.dsc.myliving.presentation.components.form.TextInput
import com.dsc.myliving.presentation.features.auth.AuthViewmodel

@Composable
fun Signup() {
    val viewmodel: AuthViewmodel = viewModel()
    val formState = remember { viewmodel.signupFormState }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        WelcomeText()

        Spacer(modifier = Modifier.height(34.dp))
        Text(text = "Email")
        TextInput(
            type = KeyboardType.Email,
            modifier = Modifier.fillMaxWidth(),
            state = formState.getState("email"),
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text("Password")
        PasswordInput(
            modifier = Modifier.fillMaxWidth(),
            state = formState.getState("password"),
        )

        Spacer(modifier = Modifier.height(12.dp))
        Text("Confirm password")
        PasswordInput(
            modifier = Modifier.fillMaxWidth(),
            state = formState.getState("confirm"),
        )


        Spacer(modifier = Modifier.height(36.dp))
        EntryButton(
            onclick = { viewmodel.signup() },
            buttonText = R.string.sign_up,
            buttonIcon = R.drawable.ic_arrow_right,
            buttonContentDescription = R.string.sign_up
        )

        Spacer(modifier = Modifier.height(16.dp))
        EntryButton(
            onclick = { /*TODO*/ },
            buttonText = R.string.google,
            buttonIcon = R.drawable.google_logo,
            buttonContentDescription = R.string.login
        )

        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.already_have_account_message),
                modifier = Modifier.align(Alignment.Center).clickable { viewmodel.current = 0 }
            )
        }
    }
}

@Composable
private fun WelcomeText() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.h1)
        Text(text = stringResource(id = R.string.new_account))
    }
}