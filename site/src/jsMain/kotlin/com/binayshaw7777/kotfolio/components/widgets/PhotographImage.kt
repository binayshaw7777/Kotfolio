package com.binayshaw7777.kotfolio.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.px

@Composable
fun PhotographImage(
    modifier: Modifier = Modifier,
    src: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth().then(modifier)
            .padding(all = 6.px),
        contentAlignment = Alignment.Center
    ) {
        Image(
            src = src,
            modifier = Modifier.fillMaxWidth().borderRadius(10.px).display(DisplayStyle.Block).fillMaxHeight()
        )
    }
}