package com.jjp.petsitter.animals.ui.description

import androidx.annotation.DrawableRes

data class AnimalDescriptionUiModel(
    val id: Long,
    val name: String,
    val description: String,
    @DrawableRes val icon: Int,
    val breed: String,
    val address: String,
    val email: String
)