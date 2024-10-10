package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Major(
    @DrawableRes val imageResId: Int,
    @StringRes val nameResId: Int,
    val coursesQuantity: Int
)
