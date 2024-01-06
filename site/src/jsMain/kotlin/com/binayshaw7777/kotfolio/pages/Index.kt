package com.binayshaw7777.kotfolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.*
import com.binayshaw7777.kotfolio.components.layouts.PageLayout
import com.binayshaw7777.kotfolio.components.sections.About
import com.binayshaw7777.kotfolio.components.sections.Experience
import com.binayshaw7777.kotfolio.components.sections.Home
import com.binayshaw7777.kotfolio.components.sections.Photography
import com.binayshaw7777.kotfolio.components.sections.Projects
import com.binayshaw7777.kotfolio.components.sections.SkillsAndTools
import com.binayshaw7777.kotfolio.utils.Res
import com.varabyte.kobweb.compose.foundation.layout.*
import com.varabyte.kobweb.silk.components.animation.Keyframes

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
    Breakpoint.MD { Modifier.margin { top(20.vh) } }
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

@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        Row(HeroContainerStyle.toModifier().fontFamily(Res.Fonts.Space_Grotesk).id("home")) {
            Box {

                Column(Modifier.gap(2.cssRem)) {

                    Home()

                    About()

                    Experience()

                    SkillsAndTools()

                    Photography()

                    Projects()
                }
            }
        }
    }
}