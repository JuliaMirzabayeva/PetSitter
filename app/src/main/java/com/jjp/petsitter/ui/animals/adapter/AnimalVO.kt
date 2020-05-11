package com.jjp.petsitter.ui.animals.adapter

import androidx.annotation.DrawableRes

data class AnimalVO
constructor(
    @DrawableRes val icon: Int,
    val breed: String,
    val address: String
)
