package com.binayshaw7777.kotfolio.components.styles

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.scale
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.percent

val BackgroundImageStyle by ComponentStyle {
    base {
        Modifier.scale(25.percent)
    }
    Breakpoint.SM {
        Modifier.scale(50.percent)
    }
    Breakpoint.MD {
        Modifier.scale(75.percent)
    }
    Breakpoint.LG {
        Modifier.scale(100.percent)
    }
}