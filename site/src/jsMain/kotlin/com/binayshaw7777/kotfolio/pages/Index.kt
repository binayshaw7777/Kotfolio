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
import com.binayshaw7777.kotfolio.components.widgets.WorkExperienceBlock
import com.binayshaw7777.kotfolio.utils.Constants
import com.binayshaw7777.kotfolio.utils.CustomColorSchemes
import com.binayshaw7777.kotfolio.utils.Res
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.silk.components.forms.ButtonSize
import com.varabyte.kobweb.silk.components.graphics.Image
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
                            text = "Software Developer and Designer",
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
                            modifier = Modifier.width(150.percent)
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
                            text = "Lorem ipsum dolor sit amet, mel no decore ancillae, qui oportere facilisis ut. Mea cu quaestio hendrerit, ea decore nusquam alienum eam. Vis novum iuvaret dissentiet ex, duo te wisi maiestatis. Aliquid eligendi mnesarchum vim ex, at graeci vivendo duo. Est cu petentium conclusionemque, tritani recusabo vel te. Pri no veniam aperiam iudicabit, id quidam quodsi urbanitas sed, ea sanctus docendi voluptua quo.",
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
                        Row(
                            modifier = Modifier.margin(topBottom = 3.cssRem),
                            horizontalArrangement = Arrangement.Center
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
