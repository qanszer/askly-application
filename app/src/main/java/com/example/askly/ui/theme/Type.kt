package com.example.askly.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.askly.R

val AppFontFamily = FontFamily(
    Font(R.font.plus_jakarta_sans_extralight,  FontWeight.ExtraLight),
    Font(R.font.plus_jakarta_sans_light,  FontWeight.Light),
    Font(R.font.plus_jakarta_sans_regular,  FontWeight.Normal),
    Font(R.font.plus_jakarta_sans_medium,   FontWeight.Medium),
    Font(R.font.plus_jakarta_sans_semibold, FontWeight.SemiBold),
    Font(R.font.plus_jakarta_sans_bold,     FontWeight.Bold),
    Font(R.font.plus_jakarta_sans_extrabold,     FontWeight.ExtraBold)
)

private val base = Typography()

val Typography = Typography(
    displayLarge   = base.displayLarge.copy(fontFamily = AppFontFamily),
    displayMedium  = base.displayMedium.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Bold, fontSize = 40.sp, lineHeight = 44.sp, letterSpacing = (-0.8).sp),
    displaySmall   = base.displaySmall.copy(fontFamily = AppFontFamily),
    headlineLarge  = base.headlineLarge.copy(fontFamily = AppFontFamily),
    headlineMedium = base.headlineMedium.copy(fontFamily = AppFontFamily),
    headlineSmall  = base.headlineSmall.copy(fontFamily = AppFontFamily),
    titleLarge     = base.titleLarge.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Medium),
    titleMedium    = base.titleMedium.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Medium, fontSize = 18.sp, lineHeight = 24.sp),
    titleSmall     = base.titleSmall.copy(fontFamily = AppFontFamily),
    bodyLarge      = base.bodyLarge.copy(fontFamily = AppFontFamily),
    bodyMedium     = base.bodyMedium.copy(fontFamily = AppFontFamily),
    bodySmall      = base.bodySmall.copy(fontFamily = AppFontFamily),
    labelLarge     = base.labelLarge.copy(fontFamily = AppFontFamily),
    labelMedium    = base.labelMedium.copy(fontFamily = AppFontFamily),
    labelSmall     = base.labelSmall.copy(fontFamily = AppFontFamily, fontWeight = FontWeight.Medium)
)