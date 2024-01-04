package com.binayshaw7777.kotfolio.components.widgets

import androidx.compose.runtime.Composable
import com.binayshaw7777.kotfolio.utils.Res.Colors.GLASS_BOX_BORDER_COLOR
import com.varabyte.kobweb.compose.css.CSSLengthNumericValue
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.MixBlendMode
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.mixBlendMode
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.BoxScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

@Composable
fun GlassBox(
    modifier: Modifier = Modifier,
    roundedCorners: CSSLengthOrPercentageNumericValue = 10.px,
    borderWidth: CSSLengthNumericValue = 2.px,
    borderStyle: LineStyle = LineStyle.Solid,
    borderColor: CSSColorValue = GLASS_BOX_BORDER_COLOR,
    gradientDirection: LinearGradient.Direction = LinearGradient.Direction.ToBottomRight,
    startColor: CSSColorValue = rgba(r = 255, g = 255, b = 255, a = 0),
    endColor: CSSColorValue = rgba(r = 255, g = 255, b = 255, a = 0.1),
    blendMode: MixBlendMode = MixBlendMode.Normal,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .margin(2.px)
                .borderRadius(roundedCorners)
                .border(width = borderWidth, style = borderStyle, color = borderColor)
                .styleModifier {
                    mixBlendMode(blendMode)
                }
                .backgroundImage(
                    linearGradient(
                        gradientDirection,
                        startColor,
                        endColor
                    )
                )
        )
        content()
    }
}