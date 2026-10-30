package com.example.askly.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val xs: Dp = 6.dp,
    val sm: Dp = 12.dp,
    val md: Dp = 16.dp,
    val lg: Dp = 22.dp,
    val xl: Dp = 32.dp,

    val screenPadding: Dp = 22.dp,
    val buttonHorizontal: Dp = 12.dp,
    val logoSize: Dp = 80.dp,
    val iconSmall: Dp = 16.dp,
    val iconButton: Dp = 48.dp,
    val cornerRadius: Dp = 8.dp
)

val LocalDimensions = staticCompositionLocalOf { Dimensions() }