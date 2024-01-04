package com.binayshaw7777.kotfolio.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.ElementRefScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.ComponentVariant
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.filter
import org.w3c.dom.HTMLImageElement

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun AppearanceAwareImage(
    src: String,
    description: String,
    modifier: Modifier = Modifier,
    variant: ComponentVariant? = null,
    width: Int? = null,
    height: Int? = null,
    autoPrefix: Boolean = true,
    ref: ElementRefScope<HTMLImageElement>? = null,
) {
    val isLight = when (ColorMode.current) {
        ColorMode.LIGHT -> true
        ColorMode.DARK -> false
    }

    Image(
        src = src,
        description = description,
        modifier = Modifier
            .styleModifier { filter { if (isLight) invert(1) else invert(0) } }
            .then(modifier),
        variant = variant,
        width = width,
        height = height,
        autoPrefix = autoPrefix,
        ref = ref
    )
}

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun AppearanceAwareImage(
    src: String,
    modifier: Modifier = Modifier,
    variant: ComponentVariant? = null,
    width: Int? = null,
    height: Int? = null,
    alt: String = "",
    autoPrefix: Boolean = true,
    ref: ElementRefScope<HTMLImageElement>? = null,
) {
    val isLight = when (ColorMode.current) {
        ColorMode.LIGHT -> true
        ColorMode.DARK -> false
    }

    Image(
        src = src,
        modifier = Modifier
            .styleModifier { filter { if (isLight) invert(1) else invert(0) } }
            .then(modifier),
        variant = variant,
        width = width,
        height = height,
        alt = alt,
        autoPrefix = autoPrefix,
        ref = ref
    )
}