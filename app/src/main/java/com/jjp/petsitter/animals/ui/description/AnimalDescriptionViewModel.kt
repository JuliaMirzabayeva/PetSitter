package com.jjp.petsitter.animals.ui.description

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjp.petsitter.animals.repository.AnimalsRepository
import javax.inject.Inject

class AnimalDescriptionViewModel
@Inject constructor(
    private val animalsRepository: AnimalsRepository,
    private val animalDescriptionMapper: AnimalDescriptionMapper
) : ViewModel() {

    private val _animal = MutableLiveData<AnimalDescriptionUiModel>()

    val animal: LiveData<AnimalDescriptionUiModel>
        get() = _animal

    fun setAnimal(id: Long) {
        animalsRepository.getAnimals().find { animal ->
            animal.id == id
        }?.let { selectedAnimal ->
            _animal.postValue(animalDescriptionMapper.mapAnimal(selectedAnimal))
        }
    }
}
