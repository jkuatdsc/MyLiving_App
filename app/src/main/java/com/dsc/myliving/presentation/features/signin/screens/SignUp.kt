package com.dsc.myliving.presentation.features.signin.screens

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dsc.myliving.R
import com.dsc.myliving.presentation.components.EntryButton
import com.dsc.myliving.presentation.components.EntryTextInput
import com.dsc.myliving.presentation.components.Validators
import com.dsc.myliving.presentation.features.signin.SignInViewModel
import com.dsc.myliving.presentation.theme.MyLivingTheme

@Composable
fun SignUp() {
    val viewModel: SignInViewModel = viewModel()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        SingUpWelcomeText()

        Spacer(modifier = Modifier.height(34.dp))

        EntryTextInput().Content(label = R.string.email)

        Spacer(modifier = Modifier.height(12.dp))

        EntryTextInput(
            Validators.Max(12, ""),
            Validators.Min(6, "")
        ).Content(label = R.string.password)

        Spacer(modifier = Modifier.height(12.dp))

        EntryTextInput(
            Validators.Max(12, "Password"),
            Validators.Min(6, "")
        ).Content(label = R.string.confirm_password)


        Spacer(modifier = Modifier.height(36.dp))

        EntryButton(
            onclick = { /*TODO*/ },
            buttonText = R.string.sign_up,
            buttonIcon = R.drawable.ic_arrow_right,
            buttonContentDescription = R.string.login
        )

        Spacer(modifier = Modifier.height(16.dp))

        EntryButton(
            onclick = { /*TODO*/ },
            buttonText = R.string.google,
            buttonIcon = R.drawable.ic_google_logo,
            buttonContentDescription = R.string.login
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.already_have_account_message),
            modifier = Modifier.clickable { viewModel.current = 0 })
    }
}

@Composable
private fun SingUpWelcomeText() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(id = R.string.app_name), style = MaterialTheme.typography.h1)
        Text(text = stringResource(id = R.string.new_account))
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, name = "light mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "dark mode")
@Composable
fun SingUnPreview() {
    MyLivingTheme {
        Surface {
            SignUp()
        }
    }
}