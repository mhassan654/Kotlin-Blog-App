package com.saavatech.composableblogui.ui.utils

import androidx.annotation.DrawableRes
import com.saavatech.composableblogui.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {

    data object First : OnBoardingPage(
        image = R.drawable.first,
        title = "First title",
        description = "first description"
    )

    data object Second : OnBoardingPage(
        image = R.drawable.second,
        title = "Second title",
        description = "second description"
    )

    data object Third : OnBoardingPage(
        image = R.drawable.third,
        title = "Third title",
        description = "third description"
    )
}