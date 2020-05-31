package com.jjp.petsitter.animals.ui.description

import android.content.Context
import androidx.annotation.DrawableRes
import com.jjp.petsitter.R
import com.jjp.petsitter.animals.data.Address
import com.jjp.petsitter.animals.data.Animal
import com.jjp.petsitter.animals.data.AnimalType
import com.jjp.petsitter.animals.data.Breeds

class AnimalDescriptionMapperImpl
constructor(
    context: Context
): AnimalDescriptionMapper {

    private val mixedBreed = context.getString(R.string.mixed)
    private val unknownBreed = context.getString(R.string.unknown)

    override fun mapAnimal(animal: Animal): AnimalDescriptionUiModel {
        return AnimalDescriptionUiModel(
            id = animal.id,
            name = animal.name,
            icon = getIcon(animal.type),
            breed = getBreed(
                animal.breeds
            ),
            address = getAddress(
                animal.contact.address
            )
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
            breeds.unknown -> unknownBreed
            breeds.mixed -> MIXED_BREED_PATTERN.format(breeds.primary, mixedBreed)
            else -> breeds.primary!!
        }
    }

    private fun getAddress(address: Address): String {
        return ADDRESS_PATTERN.format(address.city, address.country)
    }

    companion object {
        private const val MIXED_BREED_PATTERN = "%s (%s)"
        private const val ADDRESS_PATTERN = "%s %s"
    }
}