package com.binayshaw7777.kotfolio.components.sections

import androidx.compose.runtime.Composable
import com.binayshaw7777.kotfolio.components.widgets.SectionTitle
import com.binayshaw7777.kotfolio.utils.Constants
import com.binayshaw7777.kotfolio.utils.Res
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.vh

@Composable
fun About() {
    Column(
        modifier = Modifier.id("about").height(100.vh),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SectionTitle(Constants.ABOUT_ME_TITLE)

        SpanText(
            text = Constants.ABOUT_ME_TEXT,
            modifier = Modifier
                .textAlign(TextAlign.Center)
                .margin(topBottom = 2.cssRem)
                .color(
                    when (ColorMode.current) {
                        ColorMode.LIGHT -> Colors.Gray
                        ColorMode.DARK -> Colors.DimGray
                    }
                )
                .fontFamily(Res.Fonts.DM_SANS)
        )
    }
}