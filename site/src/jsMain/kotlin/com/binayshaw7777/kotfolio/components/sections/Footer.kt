package com.binayshaw7777.kotfolio.components.sections

import androidx.compose.runtime.Composable
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

val FooterStyle by ComponentStyle.base {
    Modifier
        .backgroundColor(colorMode.toSitePalette().nearBackground)
        .padding(topBottom = 1.5.cssRem, leftRight = 10.percent)
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Box(FooterStyle.toModifier().then(modifier), contentAlignment = Alignment.Center) {
        Span(Modifier.textAlign(TextAlign.Center).toAttrs()) {
            val sitePalette = ColorMode.current.toSitePalette()
            SpanText("Built with ")
            Link(
                "https://github.com/varabyte/kobweb",
                "Kobweb",
                Modifier.setVariable(ColorVar, sitePalette.brand.primary),
                variant = UncoloredLinkVariant
            )
            SpanText(", template designed by ")

            // Huge thanks to UI Rocket (https://ui-rocket.com) for putting this great template design together for us!
            // If you like what you see here and want help building your own site, consider checking out their services.
            Link(
                "https://ui-rocket.com",
                "UI Rocket",
                Modifier.setVariable(ColorVar, sitePalette.brand.accent).whiteSpace(WhiteSpace.NoWrap),
                variant = UncoloredLinkVariant
            )
        }
    }
}
