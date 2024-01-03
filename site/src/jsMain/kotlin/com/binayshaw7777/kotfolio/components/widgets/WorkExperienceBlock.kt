package com.binayshaw7777.kotfolio.components.widgets

import androidx.compose.runtime.Composable
import com.binayshaw7777.kotfolio.utils.Res
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun WorkExperienceBlock(
    modifier: Modifier = Modifier,
    sequenceNumber: String,
    role: String,
    organization: String,
    duration: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fontFamily(Res.Fonts.DM_SANS).margin(leftRight = 0.5.cssRem).then(modifier)
    ) {

        Column(
            modifier = Modifier
                .border(
                    width = 1.px, style = LineStyle.Solid, color = when (ColorMode.current) {
                        ColorMode.LIGHT -> Colors.Gray
                        ColorMode.DARK -> Colors.DimGray
                    }
                )
                .borderRadius(10.px)
                .margin(top = 2.cssRem)
                .padding(top = 30.px, bottom = 24.px, leftRight = 24.px),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            SpanText(
                text = role,
                modifier = Modifier
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Gray
                            ColorMode.DARK -> Colors.DimGray
                        }
                    )
                    .fontSize(FontSize.Small)
                    .fontWeight(FontWeight.Bold)
            )
            SpanText(
                text = organization,
                modifier = Modifier
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Black
                            ColorMode.DARK -> Colors.White
                        }
                    )
                    .fontFamily(Res.Fonts.Space_Grotesk)
                    .fontSize(FontSize.XXLarge)
                    .fontWeight(FontWeight.Bold)
            )
            SpanText(
                text = duration,
                modifier = Modifier
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Gray
                            ColorMode.DARK -> Colors.DimGray
                        }
                    )
                    .fontSize(FontSize.Small)
                    .fontWeight(FontWeight.Bold)
            )
        }

        SpanText(
            text = sequenceNumber,
            modifier = Modifier.fontSize(3.cssRem)
                .color(
                    when (ColorMode.current) {
                        ColorMode.LIGHT -> Colors.Black
                        ColorMode.DARK -> Colors.White
                    }
                )
                .margin(left = 2.cssRem)
                .align(Alignment.TopStart)
                .fontWeight(FontWeight.Bold)
        )
    }
}