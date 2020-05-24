package com.jjp.petsitter.animals.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjp.petsitter.animals.repository.AnimalsLoader
import com.jjp.petsitter.animals.ui.adapter.AnimalUiModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class AnimalsViewModel : ViewModel() {

    private val animalsLoader =
        AnimalsLoader()

    private val _animals = MutableLiveData<List<AnimalUiModel>>()

    val animals: LiveData<List<AnimalUiModel>>
        get() = _animals

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println(exception)
    }

    fun loadAnimals() = viewModelScope.launch(exceptionHandler) {
        val response = animalsLoader.loadAnimals()
        _animals.postValue(
            AnimalsMapper.mapAnimals(
                response.animals
            )
        )
    }
}
