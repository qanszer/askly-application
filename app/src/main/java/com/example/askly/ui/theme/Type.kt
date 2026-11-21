package com.example.askly.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.askly.R

val PlusJakartaSans = FontFamily(
    Font(R.font.plus_jakarta_sans_regular,  FontWeight.Normal),
    Font(R.font.plus_jakarta_sans_medium,   FontWeight.Medium),
    Font(R.font.plus_jakarta_sans_semibold, FontWeight.SemiBold),
    Font(R.font.plus_jakarta_sans_bold,     FontWeight.Bold),
)

enum class FontSizeSetting(val scale: Float) {
    Small(0.875f),
    Medium(1f),
    Large(1.15625f)
}

object AsklyFontSize {
    const val micro = 10f      // 0.625rem
    const val tiny = 11f       // 0.6875rem
    const val caption = 12f    // text-xs
    const val footnote = 13f   // 0.8125rem
    const val small = 14f      // text-sm
    const val body = 15f       // 0.9375rem
    const val lead = 16f       // text-base
    const val bodyLarge = 17f  // 1.0625rem
    const val title3 = 18f     // text-lg
    const val title2 = 20f     // text-xl / 1.25rem
    const val title1 = 24f     // text-2xl
    const val glyph = 30f      // text-3xl (large icon tile)
    const val headline = 28f   // 1.75rem
    const val display3 = 32f   // 2rem
    const val display2 = 34f   // 2.125rem
    const val display1 = 36f   // 2.25rem
    const val hero = 42f       // 2.625rem
}

@Immutable
data class AsklyTypography(
    val hero: TextStyle,          // Menu hero headline
    val codeInput: TextStyle,     // Join-code entry letter tiles
    val signInTitle: TextStyle,   // Sign-in title
    val screenTitle: TextStyle,   // Join/create title, large code tiles
    val pageTitle: TextStyle,     // Page header title
    val headline: TextStyle,      // Empty-state title, small code tiles
    val fontPreview: TextStyle,   // Settings "Aa" font-size preview
    val sectionTitle: TextStyle,  // Section headers, sheet titles, stat numbers
    val title: TextStyle,         // Dialog / empty card titles
    val cardTitle: TextStyle,     // Class card title
    val inputLarge: TextStyle,    // Question composer textarea
    val lead: TextStyle,          // Menu subtitle
    val body: TextStyle,          // Question text, paragraphs
    val bodyMedium: TextStyle,    // Buttons, list row titles
    val aboutTitle: TextStyle,    // Settings about card title
    val label: TextStyle,         // Form labels, text buttons
    val secondary: TextStyle,     // Subtitles, descriptions
    val count: TextStyle,         // Vote / question counts (tabular)
    val chip: TextStyle,          // Filter chips, segmented control
    val codeBadge: TextStyle,     // 2×2 code badge on class cards
    val footnote: TextStyle,      // Card subtitles
    val caption: TextStyle,       // Meta, helper, timestamps
    val captionMedium: TextStyle, // Small pill buttons
    val countPill: TextStyle,     // Role card count pill (tabular)
    val badge: TextStyle,         // Status chips
    val statLabel: TextStyle,     // Professor room stat labels
    val eyebrow: TextStyle,       // UPPERCASE eyebrow labels
    val micro: TextStyle,         // UPPERCASE micro labels
)

fun asklyTypography(setting: FontSizeSetting = FontSizeSetting.Medium): AsklyTypography {
    val s = setting.scale
    fun style(
        size: Float,
        lineHeight: Float,  // multiplier of size
        weight: FontWeight = FontWeight.Normal,
        tracking: Float = 0f,  // em
        tabular: Boolean = false,
    ) = TextStyle(
        fontFamily = PlusJakartaSans,
        fontSize = (size * s).sp,
        lineHeight = (size * lineHeight * s).sp,
        fontWeight = weight,
        letterSpacing = tracking.em,
        fontFeatureSettings = if (tabular) "tnum" else null,
    )
    val heading = -0.025f
    val F = AsklyFontSize
    return AsklyTypography(
        hero          = style(F.hero, 1.05f, FontWeight.Bold, -0.03f),
        codeInput     = style(F.display1, 1.0f, FontWeight.Bold, heading),
        signInTitle   = style(F.display2, 1.1f, FontWeight.Bold, heading),
        screenTitle   = style(F.display3, 1.25f, FontWeight.Bold, heading),
        pageTitle     = style(F.headline, 1.25f, FontWeight.Bold, heading),
        headline      = style(F.title1, 1.333f, FontWeight.Bold, heading),
        fontPreview   = style(F.title1, 1.333f),
        sectionTitle  = style(F.title2, 1.25f, FontWeight.Bold, heading),
        title         = style(F.title3, 1.555f, FontWeight.Bold, heading),
        cardTitle     = style(F.bodyLarge, 1.375f, FontWeight.Bold, heading),
        inputLarge    = style(F.bodyLarge, 1.625f),
        lead          = style(F.lead, 1.625f),
        body          = style(F.body, 1.625f),
        bodyMedium    = style(F.body, 1.5f, FontWeight.Medium),
        aboutTitle    = style(F.small, 1.428f, FontWeight.Bold, heading),
        label         = style(F.small, 1.428f, FontWeight.Medium),
        secondary     = style(F.small, 1.428f),
        count         = style(F.small, 1.428f, FontWeight.SemiBold, tabular = true),
        chip          = style(F.footnote, 1.5f, FontWeight.Medium),
        codeBadge     = style(F.footnote, 1.0f, FontWeight.Bold, heading),
        footnote      = style(F.footnote, 1.5f),
        caption       = style(F.caption, 1.333f),
        captionMedium = style(F.caption, 1.333f, FontWeight.Medium),
        countPill     = style(F.caption, 1.333f, FontWeight.SemiBold, tabular = true),
        badge         = style(F.tiny, 1.5f, FontWeight.SemiBold),
        statLabel     = style(F.tiny, 1.5f, FontWeight.Medium),
        eyebrow       = style(F.tiny, 1.5f, FontWeight.SemiBold, 0.2f),
        micro         = style(F.micro, 1.5f, FontWeight.SemiBold, 0.15f),
    )
}

val LocalAsklyTypography = staticCompositionLocalOf { asklyTypography() }

private val base = Typography()

val Typography = Typography(
    displayLarge   = base.displayLarge.copy(fontFamily = PlusJakartaSans),
    displayMedium  = base.displayMedium.copy(fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 40.sp, lineHeight = 44.sp, letterSpacing = (-0.8).sp),
    displaySmall   = base.displaySmall.copy(fontFamily = PlusJakartaSans),
    headlineLarge  = base.headlineLarge.copy(fontFamily = PlusJakartaSans),
    headlineMedium = base.headlineMedium.copy(fontFamily = PlusJakartaSans),
    headlineSmall  = base.headlineSmall.copy(fontFamily = PlusJakartaSans),
    titleLarge     = base.titleLarge.copy(fontFamily = PlusJakartaSans, fontWeight = FontWeight.Medium),
    titleMedium    = base.titleMedium.copy(fontFamily = PlusJakartaSans, fontWeight = FontWeight.Medium, fontSize = 18.sp, lineHeight = 24.sp),
    titleSmall     = base.titleSmall.copy(fontFamily = PlusJakartaSans),
    bodyLarge      = base.bodyLarge.copy(fontFamily = PlusJakartaSans),
    bodyMedium     = base.bodyMedium.copy(fontFamily = PlusJakartaSans),
    bodySmall      = base.bodySmall.copy(fontFamily = PlusJakartaSans),
    labelLarge     = base.labelLarge.copy(fontFamily = PlusJakartaSans),
    labelMedium    = base.labelMedium.copy(fontFamily = PlusJakartaSans),
    labelSmall     = base.labelSmall.copy(fontFamily = PlusJakartaSans, fontWeight = FontWeight.Medium)
)