package com.jjp.petsitter.animals.ui.list

import com.jjp.petsitter.animals.data.Address
import com.jjp.petsitter.animals.data.Animal
import com.jjp.petsitter.animals.data.Breeds
import com.jjp.petsitter.animals.data.Contact

const val ANIMAL_ID = 0L
const val PRIMARY_BREED = "Primary"
const val CITY = "City"
const val COUNTRY = "Country"

fun createAnimal(type: String, primaryBreed: String?): Animal {
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

fun creteAnimalWithWrongBreed(): Animal {
    return Animal(
        id = ANIMAL_ID,
        type = "",
        name = "",
        age = "",
        gender = "",
        breeds = Breeds(
            primary = null,
            secondary = null,
            mixed = false,
            unknown = false
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
