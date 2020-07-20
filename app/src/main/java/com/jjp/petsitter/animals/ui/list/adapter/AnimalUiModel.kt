package com.jjp.petsitter.animals.ui.list.adapter

import androidx.annotation.DrawableRes

data class AnimalUiModel (
    val id: Long,
    @DrawableRes val icon: Int,
    val breed: String,
    val address: String
)
