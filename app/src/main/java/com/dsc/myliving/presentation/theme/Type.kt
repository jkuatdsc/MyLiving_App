package com.dsc.myliving.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dsc.myliving.R

private val Poppins = FontFamily(
    Font(R.font.bold, FontWeight.Bold),
    Font(R.font.light, FontWeight.Light),
    Font(R.font.regular, FontWeight.Normal),
)

val typography = Typography(
    body1 = TextStyle(
        fontSize = 16.sp,
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
    ),
    button = TextStyle(
        fontSize = 14.sp,
        fontFamily = Poppins,
        fontWeight = FontWeight.W500,
    ),
    caption = TextStyle(
        fontSize = 12.sp,
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
    )
)