package com.jjp.petsitter.ui.animals.adapter

import androidx.annotation.DrawableRes

data class AnimalUiModel (
    @DrawableRes val icon: Int,
    val breed: String,
    val address: String
)
