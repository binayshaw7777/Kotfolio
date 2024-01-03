package com.binayshaw7777.kotfolio.components.widgets

import androidx.compose.runtime.Composable
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
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

@Composable
fun GlassBox(modifier: Modifier, content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        content()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .margin(2.px)
                .borderRadius(20.px)
                .border(width = 2.px, style = LineStyle.Solid, color = Color.white)
                .styleModifier {
                    mixBlendMode(MixBlendMode.Overlay)
                }
                .backgroundImage(
                    linearGradient(
                        LinearGradient.Direction.ToBottomRight,
                        rgba(r = 255, g = 255, b = 255, a = 0),
                        rgba(r = 255, g = 255, b = 255, a = 10)
                    )
                )
                .boxShadow(6.px, 4.px, 19.px, 0.px, rgba(0, 0, 0, 0.11f))
        )
    }
}