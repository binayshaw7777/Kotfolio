package com.binayshaw7777.kotfolio.components.sections

import androidx.compose.runtime.Composable
import com.binayshaw7777.kotfolio.components.widgets.IconButton
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.navigation.UncoloredLinkVariant
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.style.vars.color.ColorVar
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Span
import com.binayshaw7777.kotfolio.toSitePalette
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
import org.jetbrains.compose.web.css.FlexDirection.Companion.Row
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.textDecoration

val FooterStyle by ComponentStyle.base {
    Modifier
        .backgroundColor(colorMode.toSitePalette().nearBackground)
        .padding(topBottom = 1.5.cssRem, leftRight = 10.percent)
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Box(
        FooterStyle.toModifier().fontFamily(Res.Fonts.DM_SANS).then(modifier),
        contentAlignment = Alignment.Center
    ) {
//        Span(Modifier.textAlign(TextAlign.Center).toAttrs()) {
        val sitePalette = ColorMode.current.toSitePalette()

        Column(
            modifier = Modifier.fillMaxWidth(),
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
                modifier = Modifier.fillMaxWidth().padding(topBottom = 20.px),
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

                IconButton(
                    onClick = {

                    }
                ) {

                }
            }
        }

//            SpanText("Built with ")
//            Link(
//                "https://github.com/varabyte/kobweb",
//                "Kobweb",
//                Modifier.setVariable(ColorVar, sitePalette.brand.primary),
//                variant = UncoloredLinkVariant
//            )
//            SpanText(", template designed by ")
//
//            // Huge thanks to UI Rocket (https://ui-rocket.com) for putting this great template design together for us!
//            // If you like what you see here and want help building your own site, consider checking out their services.
//            Link(
//                "https://ui-rocket.com",
//                "UI Rocket",
//                Modifier.setVariable(ColorVar, sitePalette.brand.accent).whiteSpace(WhiteSpace.NoWrap),
//                variant = UncoloredLinkVariant
//            )
//        }
    }
}
