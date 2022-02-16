package com.dsc.myliving.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun EntryButton(
    onclick: () -> Unit,
    @StringRes buttonText: Int,
    @DrawableRes buttonIcon: Int,
    @StringRes buttonContentDescription: Int
) {
    OutlinedButton(
        onClick = onclick,
        modifier = Modifier.fillMaxWidth(),
        shape = CircleShape,
        border = BorderStroke(width = 2.dp, color = colors.onSecondary)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
        ) {
            Text(text = stringResource(id = buttonText), color = colors.onSecondary)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = rememberImagePainter(data = buttonIcon),
                contentDescription = stringResource(id = buttonContentDescription)
            )
        }
    }
}