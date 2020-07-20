package com.jjp.petsitter.animals.ui.description

import androidx.annotation.DrawableRes

data class AnimalDescriptionUiModel(
    val id: Long,
    val name: String,
    @DrawableRes val icon: Int,
    val breed: String,
    val address: String
)