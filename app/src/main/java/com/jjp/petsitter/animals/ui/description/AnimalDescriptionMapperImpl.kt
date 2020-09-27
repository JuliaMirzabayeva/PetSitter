package com.jjp.petsitter.animals.ui.description

import androidx.annotation.DrawableRes
import com.jjp.petsitter.R
import com.jjp.petsitter.animals.data.Address
import com.jjp.petsitter.animals.data.Animal
import com.jjp.petsitter.animals.data.AnimalType
import com.jjp.petsitter.animals.data.Breeds
import javax.inject.Inject

class AnimalDescriptionMapperImpl
@Inject constructor() : AnimalDescriptionMapper {

    override fun mapAnimal(animal: Animal): AnimalDescriptionUiModel {
        return AnimalDescriptionUiModel(
            id = animal.id,
            name = animal.name,
            description = animal.description ?: "",
            icon = getIcon(animal.type),
            breed = getBreed(animal.breeds),
            address = getAddress(animal.contact.address),
            email = animal.contact.email
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
        return if (breeds.unknown) UNKNOWN_BREED else breeds.primary!!
    }

    private fun getAddress(address: Address): String {
        return ADDRESS_PATTERN.format(address.city, address.country)
    }

    companion object {
        private const val UNKNOWN_BREED = "--"
        private const val ADDRESS_PATTERN = "%s %s"
    }
}
