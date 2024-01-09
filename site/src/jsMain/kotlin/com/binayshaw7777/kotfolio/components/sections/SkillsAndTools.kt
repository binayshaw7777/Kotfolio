package com.binayshaw7777.kotfolio.components.sections

import androidx.compose.runtime.Composable
import com.binayshaw7777.kotfolio.components.styles.ExperienceStyle
import com.binayshaw7777.kotfolio.components.widgets.GlassBox
import com.binayshaw7777.kotfolio.components.widgets.SectionTitle
import com.binayshaw7777.kotfolio.utils.Constants
import com.binayshaw7777.kotfolio.utils.Res
import com.varabyte.kobweb.compose.css.MixBlendMode
import com.varabyte.kobweb.compose.css.mixBlendMode
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.px

@Composable
fun SkillsAndTools() {
    Column(
        modifier = ExperienceStyle.toModifier().id("skills_and_tools"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        SectionTitle(Constants.SKILLS_AND_TOOLS_TITLE)

        SimpleGrid(
            modifier = Modifier.fillMaxWidth().margin(top = 2.cssRem),
            numColumns = numColumns(base = 1, sm = 2)
        ) {
            GlassBox(
                modifier = Modifier.margin(all = 2.cssRem)
            ) {
                SimpleGrid(
                    modifier = Modifier.padding(all = 1.cssRem),
                    numColumns = numColumns(base = 2, sm = 2, md = 3, lg = 4)
                ) {
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)
                    ) {
                        Image(
                            src = Res.Images.KOTLIN_LOGO,
                            modifier = Modifier.size(42.px)
                                .styleModifier {
                                    mixBlendMode(MixBlendMode.Normal)
                                }
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.JAVA_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.HTML_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.CSS_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }

                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.JAVASCRIPT_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.EXPRESS_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.NODEJS_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.MARKDOWN_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                }
            }

            GlassBox(
                modifier = Modifier.margin(all = 2.cssRem)
            ) {
                SimpleGrid(
                    modifier = Modifier.padding(all = 1.cssRem),
                    numColumns = numColumns(base = 2, sm = 2, md = 3, lg = 4)
                ) {
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.ANDROID_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.INTELLIJ_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.FIGMA_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.FIREBASE_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.MONGODB_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.VSCODE_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.GIT_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                    GlassBox(
                        modifier = Modifier.size(65.px)
                            .margin(all = 0.6.cssRem)

                    ) {
                        Image(
                            src = Res.Images.POSTMAN_LOGO,
                            modifier = Modifier.size(42.px)
                        )
                    }
                }
            }
        }
    }
}