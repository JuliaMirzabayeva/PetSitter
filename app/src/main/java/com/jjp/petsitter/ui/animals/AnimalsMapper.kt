package com.jjp.petsitter.ui.animals

import androidx.annotation.DrawableRes
import com.jjp.petsitter.R
import com.jjp.petsitter.model.Address
import com.jjp.petsitter.model.Animal
import com.jjp.petsitter.model.AnimalType
import com.jjp.petsitter.model.Breeds
import com.jjp.petsitter.ui.animals.adapter.AnimalVO

object AnimalsMapper {

    fun mapAnimals(animals: List<Animal>): List<AnimalVO> {
        return animals.map(this::mapAnimal)
    }

    private fun mapAnimal(animal: Animal): AnimalVO {
        return AnimalVO(
            icon = getIcon(animal.type),
            breed = getBreed(animal.breeds),
            address = getAddress(animal.contact.address)
        )
    }

    @DrawableRes
    private fun getIcon(type: String): Int {
        return when (type) {
            AnimalType.DOG.value -> R.drawable.ic_dog
            AnimalType.CAT.value -> R.drawable.ic_cat
            AnimalType.HORSE.value -> R.drawable.ic_horse
            else -> R.drawable.background_oval
        }
    }

    private fun getBreed(breeds: Breeds): String {
        return when {
            breeds.unknown -> UNKNOWN_BREED
            breeds.mixed -> MIXED_BREED_PATTERN.format(breeds.primary)
            else -> breeds.primary!!
        }
    }

    private fun getAddress(address: Address): String {
        return ADDRESS_PATTERN.format(address.city, address.country)
    }

    private const val MIXED_BREED = "Mixed"
    private const val MIXED_BREED_PATTERN = "%s ($MIXED_BREED)"
    private const val UNKNOWN_BREED = "Unknown"

    private const val ADDRESS_PATTERN = "%s %s"
}
