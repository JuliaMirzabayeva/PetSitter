package com.jjp.petsitter.animals.ui.list

import com.jjp.petsitter.R
import com.jjp.petsitter.animals.data.*
import com.jjp.petsitter.animals.ui.list.adapter.AnimalUiModel
import org.junit.Assert
import org.junit.Test

class AnimalsMapperTest {

    private fun createAnimal(type: String, primaryBreed: String?): Animal {
        return Animal(
            id = ANIMAL_ID,
            type = type,
            name = "",
            age = "",
            gender = "",
            breeds = Breeds(
                primary = primaryBreed,
                secondary = null,
                mixed = false,
                unknown = primaryBreed == null
            ),
            size = "",
            contact = Contact(
                email = "",
                phone = "",
                address = Address(
                    city = CITY,
                    country = COUNTRY
                )
            ),
            description = "",
            publishedAt = "",
            distance = 0.0
        )
    }

    @Test
    fun mapDogBreedPrimary() {
        val mapper = AnimalsMapperImpl()
        val dog = createAnimal(AnimalType.DOG.value, PRIMARY_BREED)
        val mappedDog = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_dog,
            breed = PRIMARY_BREED,
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedDog), mapper.mapAnimals(listOf(dog)))
    }

    @Test
    fun mapDogBreedUnknown() {
        val mapper = AnimalsMapperImpl()
        val dog = createAnimal(AnimalType.DOG.value, null)
        val mappedDog = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_dog,
            breed = "--",
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedDog), mapper.mapAnimals(listOf(dog)))
    }

    @Test
    fun mapCatBreedPrimary() {
        val mapper = AnimalsMapperImpl()
        val cat = createAnimal(AnimalType.CAT.value, PRIMARY_BREED)
        val mappedCat = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_cat,
            breed = PRIMARY_BREED,
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedCat), mapper.mapAnimals(listOf(cat)))
    }

    @Test
    fun mapCatBreedUnknown() {
        val mapper = AnimalsMapperImpl()
        val cat = createAnimal(AnimalType.CAT.value, null)
        val mappedCat = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_cat,
            breed = "--",
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedCat), mapper.mapAnimals(listOf(cat)))
    }

    @Test
    fun mapHorseBreedPrimary() {
        val mapper = AnimalsMapperImpl()
        val horse = createAnimal(AnimalType.HORSE.value, PRIMARY_BREED)
        val mappedHorse = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_horse,
            breed = PRIMARY_BREED,
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedHorse), mapper.mapAnimals(listOf(horse)))
    }

    @Test
    fun mapHorseBreedUnknown() {
        val mapper = AnimalsMapperImpl()
        val horse = createAnimal(AnimalType.HORSE.value, null)
        val mappedHorse = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_horse,
            breed = "--",
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedHorse), mapper.mapAnimals(listOf(horse)))
    }

    @Test
    fun mapOtherAnimalBreedPrimary() {
        val mapper = AnimalsMapperImpl()
        val horse = createAnimal("Anything", PRIMARY_BREED)
        val mappedHorse = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.background_oval,
            breed = PRIMARY_BREED,
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedHorse), mapper.mapAnimals(listOf(horse)))
    }

    @Test
    fun mapOtherAnimalBreedUnknown() {
        val mapper = AnimalsMapperImpl()
        val horse = createAnimal("Anything", null)
        val mappedHorse = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.background_oval,
            breed = "--",
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedHorse), mapper.mapAnimals(listOf(horse)))
    }

    companion object {
        private const val ANIMAL_ID = 0L
        private const val PRIMARY_BREED = "Primary"
        private const val CITY = "City"
        private const val COUNTRY = "Country"
    }
}
