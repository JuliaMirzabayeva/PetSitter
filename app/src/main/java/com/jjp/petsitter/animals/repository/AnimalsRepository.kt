package com.jjp.petsitter.animals.repository

import com.jjp.petsitter.animals.data.Animal

interface AnimalsRepository {

    fun getAnimals(): List<Animal>

    suspend fun loadAnimals(): List<Animal>
}
