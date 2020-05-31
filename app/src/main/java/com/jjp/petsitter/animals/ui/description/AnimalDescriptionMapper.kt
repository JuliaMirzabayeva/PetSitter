package com.jjp.petsitter.animals.ui.description

import com.jjp.petsitter.animals.data.Animal

interface AnimalDescriptionMapper {
    fun mapAnimal(animal: Animal): AnimalDescriptionUiModel
}
