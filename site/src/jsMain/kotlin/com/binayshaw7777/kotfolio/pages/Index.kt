package com.binayshaw7777.kotfolio.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toAttrs
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import com.binayshaw7777.kotfolio.HeadlineTextStyle
import com.binayshaw7777.kotfolio.SubheadlineTextStyle
import com.binayshaw7777.kotfolio.components.layouts.PageLayout
import com.binayshaw7777.kotfolio.components.styles.ButtonStyle
import com.binayshaw7777.kotfolio.components.widgets.AppearanceAwareImage
import com.binayshaw7777.kotfolio.components.widgets.GlassBox
import com.binayshaw7777.kotfolio.components.widgets.RoundedImage
import com.binayshaw7777.kotfolio.components.widgets.WorkExperienceBlock
import com.binayshaw7777.kotfolio.utils.Constants
import com.binayshaw7777.kotfolio.utils.CustomColorSchemes
import com.binayshaw7777.kotfolio.utils.Res
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.MixBlendMode
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.mixBlendMode
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.dom.Span

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle by ComponentStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
    Breakpoint.MD { Modifier.margin { top(20.vh) } }
}

// A demo grid that appears on the homepage because it looks good
val HomeGridStyle by ComponentStyle.base {
    Modifier.gap(0.5.cssRem).width(70.cssRem).height(18.cssRem)
}

private val GridCellColorVar by StyleVariable<Color>()
val HomeGridCellStyle by ComponentStyle.base {
    Modifier.backgroundColor(GridCellColorVar.value())
        .boxShadow(blurRadius = 0.6.cssRem, color = GridCellColorVar.value()).borderRadius(1.cssRem)
}

@Composable
private fun GridCell(color: Color, row: Int, column: Int, width: Int? = null, height: Int? = null) {
    Div(
        HomeGridCellStyle.toModifier().setVariable(GridCellColorVar, color)
            .gridItem(row, column, width, height).toAttrs()
    )
}

@Page
@Composable
fun HomePage() {
    PageLayout("Home") {
        Row(HeroContainerStyle.toModifier().fontFamily(Res.Fonts.Space_Grotesk)) {
            Box {

                Column(Modifier.gap(2.cssRem)) {

                    Div(HeadlineTextStyle.toAttrs()) {

                        Column(
                            horizontalAlignment = Alignment.Start
                        ) {

                            SpanText(
                                text = "Hello I'm",
                                modifier = Modifier
                                    .color(
                                        when (ColorMode.current) {
                                            ColorMode.LIGHT -> Colors.Gray
                                            ColorMode.DARK -> Colors.DimGray
                                        }
                                    )
                                    .fontSize(FontSize.XXLarge)
                                    .fontWeight(FontWeight.Bold)
                            )
                            SpanText(
                                text = "Binay Shaw.",
                                modifier = Modifier
                                    .color(
                                        when (ColorMode.current) {
                                            ColorMode.LIGHT -> Colors.Black
                                            ColorMode.DARK -> Colors.White
                                        }
                                    )
                                    .fontSize(FontSize.Larger)
                                    .fontWeight(FontWeight.Bold)
                            )
                        }

                    }

                    Div(SubheadlineTextStyle.toAttrs()) {
                        SpanText(
                            text = "and Nice to meet you!",
                            modifier = Modifier
                                .color(
                                    when (ColorMode.current) {
                                        ColorMode.LIGHT -> Colors.Gray
                                        ColorMode.DARK -> Colors.DimGray
                                    }
                                )
                                .fontFamily(Res.Fonts.Tauri)
                        )
                    }

                    val ctx = rememberPageContext()

                    Div(HeadlineTextStyle.toAttrs()) {
                        Button(
                            onClick = {
                                ctx.router.navigateTo(Constants.RESUME_URL)
                            },
                            colorScheme = CustomColorSchemes.BlackAndWhite,
                            size = ButtonSize.MD,
                            modifier = ButtonStyle.toModifier().width(150.percent)
                        ) {
                            SpanText(
                                text = "Resume",
                                modifier = Modifier.fontFamily(Res.Fonts.Tauri)
                            )
                        }
                    }

                    Column(
                        modifier = Modifier.margin(top = 10.cssRem),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Div(SubheadlineTextStyle.toAttrs()) {
                                SpanText(
                                    text = "About me.",
                                    modifier = Modifier
                                        .align(Alignment.Bottom)
                                        .fontSize(FontSize.XXLarge)
                                        .color(
                                            when (ColorMode.current) {
                                                ColorMode.LIGHT -> Colors.Black
                                                ColorMode.DARK -> Colors.White
                                            }
                                        )
                                        .fontWeight(FontWeight.Bold)
                                )
                            }
                            Image(
                                src = Res.Images.PORTAL_STAR,
                                modifier = Modifier
                                    .align(Alignment.Top)
                                    .size(22.px)
                            )
                        }

                        SpanText(
                            text = "Binay is a versatile Software Developer proficient in both Android and iOS development. Additionally, he demonstrates a hands-on approach to crafting elegant User Interfaces, showcasing a talent for bug resolution and consistently delivering optimal results.",
                            modifier = Modifier
                                .textAlign(TextAlign.Center)
                                .margin(topBottom = 2.cssRem)
                                .color(
                                    when (ColorMode.current) {
                                        ColorMode.LIGHT -> Colors.Gray
                                        ColorMode.DARK -> Colors.DimGray
                                    }
                                )
                                .fontFamily(Res.Fonts.DM_SANS)
                        )
                    }

                    Column(
                        modifier = Modifier.margin(top = 6.cssRem),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Div(SubheadlineTextStyle.toAttrs()) {
                                SpanText(
                                    text = "Work Experience.",
                                    modifier = Modifier
                                        .align(Alignment.Bottom)
                                        .fontSize(FontSize.XXLarge)
                                        .color(
                                            when (ColorMode.current) {
                                                ColorMode.LIGHT -> Colors.Black
                                                ColorMode.DARK -> Colors.White
                                            }
                                        )
                                        .fontWeight(FontWeight.Bold)
                                )
                            }
                            Image(
                                src = Res.Images.PORTAL_STAR,
                                modifier = Modifier
                                    .align(Alignment.Top)
                                    .size(22.px)
                            )
                        }

                        Span(
                            Modifier
                                .textAlign(TextAlign.Center)
                                .margin(top = 2.cssRem)
                                .fontFamily(Res.Fonts.DM_SANS)
                                .color(
                                    when (ColorMode.current) {
                                        ColorMode.LIGHT -> Colors.Gray
                                        ColorMode.DARK -> Colors.DimGray
                                    }
                                )
                                .toAttrs()
                        ) {
                            SpanText(
                                text = "I’m a Software Developer Engineer, specializing in Android & Backend Development with "
                            )
                            SpanText(
                                text = "5 months",
                                modifier = Modifier
                                    .color(
                                        when (ColorMode.current) {
                                            ColorMode.LIGHT -> Colors.Black
                                            ColorMode.DARK -> Colors.White
                                        }
                                    )
                            )
                            SpanText(
                                text = " of Internship Experience."
                            )
                        }

                        SimpleGrid(
                            numColumns = numColumns(base = 1, md = 3),
                            modifier = Modifier.margin(topBottom = 2.cssRem)
                        ) {
                            WorkExperienceBlock(
                                sequenceNumber = "01",
                                role = "Software Developer Intern",
                                organization = "IONAGE",
                                duration = "July 23 - Present"
                            )

                            WorkExperienceBlock(
                                sequenceNumber = "02",
                                role = "Software Developer Intern",
                                organization = "Humara Nagar",
                                duration = "Jan 23 - Mar 23"
                            )

                            WorkExperienceBlock(
                                sequenceNumber = "03",
                                role = "Software Developer Intern",
                                organization = "Edvora",
                                duration = "Oct 22 - Nov 22"
                            )
                        }
//                        Row(
//                            modifier = Modifier.margin(topBottom = 3.cssRem),
//                            horizontalArrangement = Arrangement.Center
//                        ) {
//
//                            WorkExperienceBlock(
//                                sequenceNumber = "01",
//                                role = "Software Developer Intern",
//                                organization = "IONAGE",
//                                duration = "July 23 - Present"
//                            )
//
//                            WorkExperienceBlock(
//                                sequenceNumber = "02",
//                                role = "Software Developer Intern",
//                                organization = "Humara Nagar",
//                                duration = "Jan 23 - Mar 23"
//                            )
//
//                            WorkExperienceBlock(
//                                sequenceNumber = "03",
//                                role = "Software Developer Intern",
//                                organization = "Edvora",
//                                duration = "Oct 22 - Nov 22"
//                            )
//                        }
                    }

                    Column(
                        modifier = Modifier.fillMaxWidth().margin(top = 8.cssRem),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Div(SubheadlineTextStyle.toAttrs()) {
                                SpanText(
                                    text = "Skills & Tools.",
                                    modifier = Modifier
                                        .align(Alignment.Bottom)
                                        .fontSize(FontSize.XXLarge)
                                        .color(
                                            when (ColorMode.current) {
                                                ColorMode.LIGHT -> Colors.Black
                                                ColorMode.DARK -> Colors.White
                                            }
                                        )
                                        .fontWeight(FontWeight.Bold)
                                )
                            }
                            Image(
                                src = Res.Images.PORTAL_STAR,
                                modifier = Modifier
                                    .align(Alignment.Top)
                                    .size(22.px)
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth().padding(top = 2.cssRem),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            GlassBox(
                                modifier = Modifier.margin(leftRight = 1.cssRem)
                            ) {
                                Column(
                                    modifier = Modifier.padding(all = 1.5.cssRem)
                                ) {
                                    Row(
                                        modifier = Modifier.margin(bottom = 0.6.cssRem)
                                    ) {
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
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
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.JAVA_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.HTML_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.CSS_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier.margin(top = 0.6.cssRem)
                                    ) {
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.JAVASCRIPT_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.EXPRESS_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.NODEJS_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.MARKDOWN_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                    }
                                }
                            }
                            GlassBox(
                                modifier = Modifier.margin(leftRight = 1.cssRem)
                            ) {
                                Column(
                                    modifier = Modifier.padding(all = 1.5.cssRem),
                                ) {
                                    Row(
                                        modifier = Modifier.margin(bottom = 0.6.cssRem)
                                    ) {
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.ANDROID_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.INTELLIJ_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.FIGMA_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.FIREBASE_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                    }
                                    Row(
                                        modifier = Modifier.margin(top = 0.6.cssRem)
                                    ) {
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.MONGODB_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.VSCODE_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
                                        ) {
                                            Image(
                                                src = Res.Images.GIT_LOGO,
                                                modifier = Modifier.size(42.px)
                                            )
                                        }
                                        GlassBox(
                                            modifier = Modifier.size(65.px)
                                                .margin(leftRight = 0.6.cssRem)
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

                    Column(
                        modifier = Modifier.fillMaxWidth().margin(top = 10.cssRem),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Div(SubheadlineTextStyle.toAttrs()) {
                                SpanText(
                                    text = "Sometimes I love to click.",
                                    modifier = Modifier
                                        .align(Alignment.Bottom)
                                        .fontSize(FontSize.XXLarge)
                                        .color(
                                            when (ColorMode.current) {
                                                ColorMode.LIGHT -> Colors.Black
                                                ColorMode.DARK -> Colors.White
                                            }
                                        )
                                        .fontWeight(FontWeight.Bold)
                                )
                            }
                            Image(
                                src = Res.Images.PORTAL_STAR,
                                modifier = Modifier
                                    .align(Alignment.Top)
                                    .size(22.px)
                            )
                        }


                    }

                    Column(
                        modifier = Modifier.fillMaxWidth().margin(top = 10.cssRem),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row {
                            Div(SubheadlineTextStyle.toAttrs()) {
                                SpanText(
                                    text = "My Side Projects.",
                                    modifier = Modifier
                                        .align(Alignment.Bottom)
                                        .fontSize(FontSize.XXLarge)
                                        .color(
                                            when (ColorMode.current) {
                                                ColorMode.LIGHT -> Colors.Black
                                                ColorMode.DARK -> Colors.White
                                            }
                                        )
                                        .fontWeight(FontWeight.Bold)
                                )
                            }
                            Image(
                                src = Res.Images.PORTAL_STAR,
                                modifier = Modifier
                                    .align(Alignment.Top)
                                    .size(22.px)
                            )
                        }
                        SpanText(
                            text = "I really have a bad habit of creating projects over projects XD",
                            modifier = Modifier
                                .textAlign(TextAlign.Center)
                                .margin(topBottom = 0.5.cssRem)
                                .color(
                                    when (ColorMode.current) {
                                        ColorMode.LIGHT -> Colors.Gray
                                        ColorMode.DARK -> Colors.DimGray
                                    }
                                )
                                .fontFamily(Res.Fonts.DM_SANS)
                        )

                        SimpleGrid(
                            numColumns = numColumns(base = 1, md = 3),
                            modifier = Modifier.fillMaxWidth().margin(top = 3.cssRem, bottom = 6.cssRem)
                        ) {
                            RoundedImage(
                                src = Res.Images.PROJECT_READBUD,
                                navigateTo = Constants.PROJECT_READBUD_URL
                            )
                            RoundedImage(
                                src = Res.Images.PROJECT_JUSTAP,
                                navigateTo = Constants.PROJECT_JUSTAP_URL
                            )
                            RoundedImage(
                                src = Res.Images.PROJECT_PASSGENIE,
                                navigateTo = Constants.PROJECT_PASSGENIE_URL
                            )
                            RoundedImage(
                                src = Res.Images.PROJECT_MEDIFY,
                                navigateTo = Constants.PROJECT_MEDIFY_URL
                            )
                            RoundedImage(
                                src = Res.Images.PROJECT_PRESIN,
                                navigateTo = Constants.PROJECT_PRESIN_URL
                            )
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Link(
                                        path = "https://github.com/binayshaw7777?tab=repositories",
                                        text = "More on GitHub.",
                                        modifier = Modifier
                                            .fontFamily(Res.Fonts.DM_SANS)
                                            .color(
                                                when (ColorMode.current) {
                                                    ColorMode.LIGHT -> Colors.Black
                                                    ColorMode.DARK -> Colors.White
                                                }
                                            )
                                            .margin(right = 4.px)
                                    )
                                    AppearanceAwareImage(
                                        src = Res.Images.NAVIGATION_ARROW
                                    )
                                }
                            }
                        }
                    }

                }

//                    Div(HeadlineTextStyle.toAttrs()) {
//                        SpanText(
//                            "Use this template as your starting point for ", Modifier.color(
//                                when (ColorMode.current) {
//                                    ColorMode.LIGHT -> Colors.Black
//                                    ColorMode.DARK -> Colors.White
//                                }
//                            )
//                        )
//                        SpanText(
//                            "Kobweb",
//                            Modifier
//                                .color(sitePalette.brand.accent)
//                                // Use a shadow so this light-colored word is more visible in light mode
//                                .textShadow(0.px, 0.px, blurRadius = 0.5.cssRem, color = Colors.Gray)
//                        )
//                    }
//
//                    Div(SubheadlineTextStyle.toAttrs()) {
//                        SpanText("You can read the ")
//                        Link("/about", "About")
//                        SpanText(" page for more information.")
//                    }
//
//                    val ctx = rememberPageContext()
//                    Button(onClick = {
//                        // Change this click handler with your call-to-action behavior
//                        // here. Link to an order page? Open a calendar UI? Play a movie?
//                        // Up to you!
//                        ctx.router.tryRoutingTo("/about")
//                    }, colorScheme = ColorSchemes.Blue) {
//                        Text("This could be your CTA")
//                    }
//                }
            }

//            Div(HomeGridStyle
//                .toModifier()
//                .displayIfAtLeast(Breakpoint.MD)
//                .grid {
//                    rows { repeat(3) { size(1.fr) } }
//                    columns { repeat(5) {size(1.fr) } }
//                }
//                .toAttrs()
//            ) {
//                val sitePalette = ColorMode.current.toSitePalette()
//                GridCell(sitePalette.brand.primary, 1, 1, 2, 2)
//                GridCell(ColorSchemes.Monochrome._600, 1, 3)
//                GridCell(ColorSchemes.Monochrome._100, 1, 4, width = 2)
//                GridCell(sitePalette.brand.accent, 2, 3, width = 2)
//                GridCell(ColorSchemes.Monochrome._300, 2, 5)
//                GridCell(ColorSchemes.Monochrome._800, 3, 1, width = 5)
//            }
        }
    }
}
