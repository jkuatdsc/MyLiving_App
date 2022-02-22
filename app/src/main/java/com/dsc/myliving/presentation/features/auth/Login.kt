package com.dsc.myliving.presentation.features.auth

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
import com.dsc.myliving.presentation.components.PasswordInput
import com.dsc.myliving.presentation.components.TextInput

@Composable
fun Login() {
    val viewmodel: AuthViewmodel = viewModel()
    val formState = remember { viewmodel.loginFormState }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp).fillMaxSize()
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

        Spacer(modifier = Modifier.height(36.dp))
        EntryButton(
            onclick = { viewmodel.login() },
            buttonText = R.string.login,
            buttonIcon = R.drawable.ic_right,
            buttonContentDescription = R.string.login
        )

        Spacer(modifier = Modifier.height(16.dp))
        EntryButton(
            onclick = { /*TODO*/ },
            buttonText = R.string.google,
            buttonIcon = R.drawable.ic_google,
            buttonContentDescription = R.string.login
        )

        Spacer(modifier = Modifier.height(16.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = stringResource(id = R.string.no_account_message),
                modifier = Modifier.align(Alignment.Center).clickable { viewmodel.current = 1 },
            )
        }
    }
}

@Composable
private fun WelcomeText() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.h1)
        Text(text = stringResource(id = R.string.login_message))
    }
}