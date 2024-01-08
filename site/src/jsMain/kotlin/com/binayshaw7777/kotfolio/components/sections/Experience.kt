package com.binayshaw7777.kotfolio.components.sections

import androidx.compose.runtime.Composable
import com.binayshaw7777.kotfolio.components.styles.ExperienceStyle
import com.binayshaw7777.kotfolio.components.styles.SectionDescriptionStyle
import com.binayshaw7777.kotfolio.components.widgets.SectionTitle
import com.binayshaw7777.kotfolio.components.widgets.WorkExperienceBlock
import com.binayshaw7777.kotfolio.utils.Constants
import com.binayshaw7777.kotfolio.utils.Res
import com.binayshaw7777.kotfolio.utils.getAllWorkExperience
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.dom.Span

@Composable
fun Experience() {
    Column(
        modifier = ExperienceStyle.toModifier().id("experience"),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        SectionTitle(Constants.EXPERIENCE_TITLE)

        Span(
            SectionDescriptionStyle.toModifier()
                .textAlign(TextAlign.Center)
                .fontFamily(Res.Fonts.DM_SANS)
                .color(
                    when (ColorMode.current) {
                        ColorMode.LIGHT -> Colors.Gray
                        ColorMode.DARK -> Colors.DimGray
                    }
                )
                .toAttrs()
        ) {
            SpanText(
                text = Constants.EXPERIENCE_SECTION_TEXT
            )
            SpanText(
                text = Constants.FIVE_MONTH,
                modifier = Modifier
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Black
                            ColorMode.DARK -> Colors.White
                        }
                    )
            )
            SpanText(
                text = Constants.OF_INTERNSHIP
            )
        }

        SimpleGrid(
            numColumns = numColumns(base = 1, md = 3),
            modifier = Modifier.margin(topBottom = 2.cssRem)
        ) {
            val workExperiences = getAllWorkExperience()

            repeat(workExperiences.size) {
                WorkExperienceBlock(workExperience = workExperiences[it])
            }
        }
    }
}