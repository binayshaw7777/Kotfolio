package com.binayshaw7777.kotfolio.utils

import com.binayshaw7777.kotfolio.components.model.WorkExperience

fun getAllProjects() =
    listOf(
        Pair(Res.Images.PROJECT_READBUD, Constants.PROJECT_READBUD_URL),
        Pair(Res.Images.PROJECT_JUSTAP, Constants.PROJECT_JUSTAP_URL),
        Pair(Res.Images.PROJECT_PASSGENIE, Constants.PROJECT_PASSGENIE_URL),
        Pair(Res.Images.PROJECT_MEDIFY, Constants.PROJECT_MEDIFY_URL),
        Pair(Res.Images.PROJECT_PRESIN, Constants.PROJECT_PRESIN_URL)
    )

fun getAllWorkExperience() = listOf(
    WorkExperience(
        sequenceNumber = "01",
        role = "Software Developer Intern",
        organization = "IONAGE",
        duration = "July 23 - Present"
    ),
    WorkExperience(
        sequenceNumber = "02",
        role = "Software Developer Intern",
        organization = "Humara Nagar",
        duration = "Jan 23 - Mar 23"
    ),
    WorkExperience(
        sequenceNumber = "03",
        role = "Software Developer Intern",
        organization = "Edvora",
        duration = "Oct 22 - Nov 22"
    )
)

fun getAllPhotographs() =
    listOf(
        Res.Images.IMAGE_1,
        Res.Images.IMAGE_2,
        Res.Images.IMAGE_3,
        Res.Images.IMAGE_4,
        Res.Images.IMAGE_5,
        Res.Images.IMAGE_6,
        Res.Images.IMAGE_7,
        Res.Images.IMAGE_8,
        Res.Images.IMAGE_9,
        Res.Images.IMAGE_10,
        Res.Images.IMAGE_11,
        Res.Images.IMAGE_12
    )