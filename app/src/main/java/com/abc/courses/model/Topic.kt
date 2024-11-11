package com.abc.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameId: Int,
    var availableCourses: Int,
    @DrawableRes val imageId: Int
)
