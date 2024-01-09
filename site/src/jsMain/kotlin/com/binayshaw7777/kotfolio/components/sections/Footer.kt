package com.binayshaw7777.kotfolio.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.binayshaw7777.kotfolio.components.styles.ButtonStyle
import com.binayshaw7777.kotfolio.components.widgets.AppearanceAwareImage
import com.binayshaw7777.kotfolio.components.widgets.IconButtonNoHover
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import com.binayshaw7777.kotfolio.utils.Constants
import com.binayshaw7777.kotfolio.utils.CustomColorSchemes
import com.binayshaw7777.kotfolio.utils.Res
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.px

val FooterStyle by ComponentStyle.base {
    Modifier.padding(topBottom = 1.5.cssRem, leftRight = 10.percent)
}

@Composable
fun Footer(breakpoint: Breakpoint, modifier: Modifier = Modifier) {

    val footerColor = when (ColorMode.current) {
        ColorMode.LIGHT -> Res.Colors.FOOTER_COLOR_LIGHT
        ColorMode.DARK -> Res.Colors.FOOTER_COLOR_DARK
    }

    var isHorizontal by remember { mutableStateOf(true) }

    isHorizontal = breakpoint >= Breakpoint.MD

    val footerTextAlignment = if (isHorizontal) TextAlign.Start else TextAlign.Center
    val footerColumnAlignment = if (isHorizontal) Alignment.Start else Alignment.CenterHorizontally


    FooterContent(breakpoint, footerTextAlignment, footerColumnAlignment, footerColor, modifier)
}

@Composable
fun EmailButton(ctx: PageContext) {
    Button(
        onClick = {
            ctx.router.navigateTo(Constants.MAIL_TO)
        },
        colorScheme = CustomColorSchemes.BlackAndWhite,
        size = ButtonSize.MD,
        modifier = ButtonStyle.toModifier().margin(right = 20.px)
    ) {
        SpanText(
            text = "Email",
            modifier = Modifier.fontFamily(Res.Fonts.DM_SANS)
        )
    }
}

@Composable
fun ResumeButton() {
    Link(
        path = Constants.RESUME_URL,
        text = "Resume.",
        modifier = Modifier
            .fontFamily(Res.Fonts.DM_SANS)
            .color(
                when (ColorMode.current) {
                    ColorMode.LIGHT -> Colors.Black
                    ColorMode.DARK -> Colors.White
                }
            )
    )
}

@Composable
fun EmailAndResume(ctx: PageContext) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        EmailButton(ctx)
        ResumeButton()
    }
}

@Composable
fun FooterContent(
    breakpoint: Breakpoint,
    footerTextAlignment: TextAlign,
    footerColumnAlignment: Alignment.Horizontal,
    footerColor: Color.Rgb,
    modifier: Modifier
) {

    Box(
        FooterStyle.toModifier().backgroundColor(footerColor).fontFamily(Res.Fonts.DM_SANS)
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier.fillMaxWidth().margin(top = 2.cssRem),
            horizontalAlignment = footerColumnAlignment
        ) {

            SpanText(
                text = "Feel free to reach out to me via mail or any of the listed mediums",
                modifier = Modifier
                    .fillMaxWidth()
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Gray
                            ColorMode.DARK -> Colors.DimGray
                        }
                    )
                    .textAlign(footerTextAlignment)
                    .fontSize(FontSize.Small)
            )

            val ctx = rememberPageContext()

            if (breakpoint >= Breakpoint.MD) {

                Row(
                    modifier = Modifier.fillMaxWidth().padding(topBottom = 2.cssRem),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    EmailAndResume(ctx)

                    Spacer()

                    NetworkingIconButtons(ctx)
                }
            } else {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(topBottom = 2.cssRem),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    EmailAndResume(ctx)

                    Spacer()

                    NetworkingIconButtons(ctx, Modifier.margin(top = 2.cssRem))
                }
            }
        }
    }
}

@Composable
fun NetworkingIconButtons(ctx: PageContext, modifier: Modifier = Modifier) {
    SimpleGrid(
        modifier = modifier,
        numColumns = numColumns(base = 5)
    ) {

        IconButtonNoHover(
            onClick = { ctx.router.navigateTo(Constants.LINKEDIN_URL) }
        ) {
            AppearanceAwareImage(src = Res.Images.LINKEDIN)
        }
        IconButtonNoHover(
            onClick = { ctx.router.navigateTo(Constants.GITHUB_URL) }
        ) {
            AppearanceAwareImage(src = Res.Images.GITHUB)
        }
        IconButtonNoHover(
            onClick = { ctx.router.navigateTo(Constants.TWITTER_URL) }
        ) {
            AppearanceAwareImage(src = Res.Images.TWITTER_X)
        }
        IconButtonNoHover(
            onClick = { ctx.router.navigateTo(Constants.BEHANCE_URL) }
        ) {
            AppearanceAwareImage(src = Res.Images.BEHANCE)
        }
        IconButtonNoHover(
            onClick = { ctx.router.navigateTo(Constants.MEDIUM_URL) }
        ) {
            AppearanceAwareImage(src = Res.Images.MEDIUM)
        }
    }
}