package com.jjp.petsitter.animals.ui.list

import com.jjp.petsitter.animals.data.Animal
import com.jjp.petsitter.animals.ui.list.adapter.AnimalUiModel

interface AnimalsMapper {
    fun mapAnimals(animals: List<Animal>): List<AnimalUiModel>
}
