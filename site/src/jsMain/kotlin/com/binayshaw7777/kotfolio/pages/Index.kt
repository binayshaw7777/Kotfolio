package com.binayshaw7777.kotfolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
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
        Row(
            Modifier.fillMaxWidth().fontFamily(Res.Fonts.Space_Grotesk).id("home")
        ) {
            Box {

                Column {

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