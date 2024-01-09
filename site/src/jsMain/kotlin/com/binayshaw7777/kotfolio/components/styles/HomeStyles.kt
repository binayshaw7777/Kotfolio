package com.binayshaw7777.kotfolio.components.styles

import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.animation.Keyframes
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

val HeroSectionStyle by ComponentStyle {
    base {
        Modifier
            .width(100.percent)
            .fontSize(3.cssRem)
            .height(100.vh)
    }
    Breakpoint.ZERO {
        Modifier
            .width(100.percent)
            .fontSize(2.5.cssRem)
            .height(50.vh)
    }
    Breakpoint.SM {
        Modifier
            .width(100.percent)
            .fontSize(2.5.cssRem)
            .height(50.vh)
    }
    Breakpoint.MD {
        Modifier
            .width(100.percent)
            .fontSize(2.75.cssRem)
            .height(85.vh)
    }
    Breakpoint.LG {
        Modifier
            .width(100.percent)
            .fontSize(3.cssRem)
            .height(100.vh)
    }
}

val HelloImStyle by ComponentStyle {
    base {
        Modifier.fontSize(FontSize.Medium).margin(top = 2.cssRem)
    }
    Breakpoint.SM {
        Modifier.fontSize(FontSize.Large)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.XLarge)
    }
    Breakpoint.LG {
        Modifier.fontSize(FontSize.XXLarge)
    }
}

val UserNameStyle by ComponentStyle {
    base {
        Modifier.fontSize(FontSize.XLarge)
    }
    Breakpoint.SM {
        Modifier.fontSize(FontSize.XXLarge)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.Larger)
    }
    Breakpoint.LG {
        Modifier.fontSize(FontSize.Larger)
    }
}

val UsersMessageStyle by ComponentStyle {
    base {
        Modifier.fontSize(FontSize.Medium)
    }
    Breakpoint.SM {
        Modifier.fontSize(FontSize.Large)
    }
    Breakpoint.MD {
        Modifier.fontSize(FontSize.Large)
    }
    Breakpoint.LG {
        Modifier.fontSize(FontSize.XLarge)
    }
}

val HeroContainerKeyFrames by Keyframes {
    0.percent {
        Modifier
            .margin(top = 50.px)
            .opacity(0)
    }
    100.percent {
        Modifier
            .margin(top = 0.px)
            .opacity(1)
    }
}