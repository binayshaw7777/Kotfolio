package com.binayshaw7777.kotfolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.binayshaw7777.kotfolio.components.layouts.PageLayout
import com.binayshaw7777.kotfolio.components.sections.About
import com.binayshaw7777.kotfolio.components.sections.Experience
import com.binayshaw7777.kotfolio.components.sections.Home
import com.binayshaw7777.kotfolio.components.sections.Photography
import com.binayshaw7777.kotfolio.components.sections.Projects
import com.binayshaw7777.kotfolio.components.sections.SkillsAndTools
import com.binayshaw7777.kotfolio.utils.Res
import com.varabyte.kobweb.compose.foundation.layout.*

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