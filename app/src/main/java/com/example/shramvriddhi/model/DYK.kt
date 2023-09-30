package com.example.shramvriddhi.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DYK(
    @StringRes val stringResourceId:Int,
    @DrawableRes val imageResourceId:Int
)
