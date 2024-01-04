package com.binayshaw7777.kotfolio.components.sections

import androidx.compose.runtime.Composable
import com.binayshaw7777.kotfolio.components.widgets.AppearanceAwareImage
import com.binayshaw7777.kotfolio.components.widgets.IconButtonNoHover
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
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
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textDecoration
import org.jetbrains.compose.web.dom.Div

val FooterStyle by ComponentStyle.base {
    Modifier.padding(topBottom = 1.5.cssRem, leftRight = 10.percent)
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    val footerColor = when (ColorMode.current) {
        ColorMode.LIGHT -> Res.Colors.FOOTER_COLOR_LIGHT
        ColorMode.DARK -> Res.Colors.FOOTER_COLOR_DARK
    }
    Box(
        FooterStyle.toModifier().backgroundColor(footerColor).fontFamily(Res.Fonts.DM_SANS).then(modifier),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier.fillMaxWidth().margin(top = 2.cssRem),
            horizontalAlignment = Alignment.Start
        ) {
            SpanText(
                text = "Feel free to reach out to me via mail or any of the listed mediums",
                modifier = Modifier
                    .color(
                        when (ColorMode.current) {
                            ColorMode.LIGHT -> Colors.Gray
                            ColorMode.DARK -> Colors.DimGray
                        }
                    )
                    .fontSize(FontSize.Small)
                    .align(Alignment.Start)
            )

            val ctx = rememberPageContext()

            Row(
                modifier = Modifier.fillMaxWidth().padding(topBottom = 2.cssRem),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Button(
                    onClick = {
                        ctx.router.navigateTo(Constants.MAIL_TO)
                    },
                    colorScheme = CustomColorSchemes.BlackAndWhite,
                    size = ButtonSize.MD,
                    modifier = Modifier.padding(leftRight = 20.px).margin(right = 20.px)
                ) {
                    SpanText(
                        text = "Email",
                        modifier = Modifier.fontFamily(Res.Fonts.Tauri)
                    )
                }

                SpanText(
                    text = "Resume.",
                    modifier = Modifier
                        .styleModifier {
                            textDecoration("underline")
                        }
                        .onClick {
                            ctx.router.navigateTo(Constants.RESUME_URL)
                        }
                )

                Spacer()

                Div(
                    Modifier
                        .display(DisplayStyle.Grid)
                        .gap(10.px)
                        .gridTemplateColumns { repeat(6) { minmax(0.2.cssRem, 1.fr) } }
                        .gridTemplateRows { repeat(1) { minmax(0.px, 1.fr) } }
                        .styleModifier {
                            property("grid-row-columns", "masonry")
                        }
                        .toAttrs()
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
        }
    }
}