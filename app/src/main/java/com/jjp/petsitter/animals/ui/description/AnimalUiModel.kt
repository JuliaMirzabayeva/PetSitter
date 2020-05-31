package com.jjp.petsitter.animals.ui.description

import androidx.annotation.DrawableRes

data class AnimalUiModel(
    @DrawableRes val icon: Int,
    val breed: String,
    val address: String
)