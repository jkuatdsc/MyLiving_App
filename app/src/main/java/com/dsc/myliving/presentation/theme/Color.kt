package com.dsc.myliving.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val red = Color(0xffe84855)
val grey = Color(0xff808B96)
val white = Color(0xfffffbff)
val black = Color(0xff202638)
val green = Color(0xff157f1f)
val yellow = Color(0xfffabc3c)

val dark = darkColors(
    error = red,
    primary = grey,
    surface = black,
    onError = white,
    onSecondary = white,
    primaryVariant = grey,
)

@SuppressLint("ConflictingOnColor")
val light = lightColors(
    error = red,
    primary = white,
    surface = white,
    onError = white,
    onPrimary = black,
    background = white,
    onSecondary = black,
    primaryVariant = grey,
)
