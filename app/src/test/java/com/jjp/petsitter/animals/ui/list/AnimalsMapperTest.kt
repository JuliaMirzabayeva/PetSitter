package com.jjp.petsitter.animals.ui.list

import com.jjp.petsitter.R
import com.jjp.petsitter.animals.data.AnimalType
import com.jjp.petsitter.animals.ui.list.adapter.AnimalUiModel
import org.junit.Assert
import org.junit.Test

class AnimalsMapperTest {

    @Test
    fun mapDogBreedPrimary() {
        val dog = createAnimal(AnimalType.DOG.value, PRIMARY_BREED)
        val mappedDog = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_dog,
            breed = PRIMARY_BREED,
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedDog), AnimalsMapper.mapAnimals(listOf(dog)))
    }

    @Test
    fun mapDogBreedUnknown() {
        val dog = createAnimal(AnimalType.DOG.value, null)
        val mappedDog = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_dog,
            breed = "--",
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedDog), AnimalsMapper.mapAnimals(listOf(dog)))
    }

    @Test
    fun mapCatBreedPrimary() {
        val cat = createAnimal(AnimalType.CAT.value, PRIMARY_BREED)
        val mappedCat = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_cat,
            breed = PRIMARY_BREED,
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedCat), AnimalsMapper.mapAnimals(listOf(cat)))
    }

    @Test
    fun mapCatBreedUnknown() {
        val cat = createAnimal(AnimalType.CAT.value, null)
        val mappedCat = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_cat,
            breed = "--",
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedCat), AnimalsMapper.mapAnimals(listOf(cat)))
    }

    @Test
    fun mapHorseBreedPrimary() {
        val horse = createAnimal(AnimalType.HORSE.value, PRIMARY_BREED)
        val mappedHorse = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_horse,
            breed = PRIMARY_BREED,
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedHorse), AnimalsMapper.mapAnimals(listOf(horse)))
    }

    @Test
    fun mapHorseBreedUnknown() {
        val horse = createAnimal(AnimalType.HORSE.value, null)
        val mappedHorse = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.ic_horse,
            breed = "--",
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedHorse), AnimalsMapper.mapAnimals(listOf(horse)))
    }

    @Test
    fun mapOtherAnimalBreedPrimary() {
        val animal = createAnimal("Anything", PRIMARY_BREED)
        val mappedAnimal = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.background_oval,
            breed = PRIMARY_BREED,
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedAnimal), AnimalsMapper.mapAnimals(listOf(animal)))
    }

    @Test
    fun mapOtherAnimalBreedUnknown() {
        val horse = createAnimal("Anything", null)
        val mappedHorse = AnimalUiModel(
            id = ANIMAL_ID,
            icon = R.drawable.background_oval,
            breed = "--",
            address = "$CITY $COUNTRY"
        )
        Assert.assertEquals(listOf(mappedHorse), AnimalsMapper.mapAnimals(listOf(horse)))
    }

    @Test(expected = NullPointerException::class)
    fun mapAnimalWithWrongBreed() {
        AnimalsMapper.mapAnimals(listOf(creteAnimalWithWrongBreed()))
    }
}
