package com.jjp.petsitter.animals.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjp.petsitter.animals.repository.AnimalsRepository
import com.jjp.petsitter.animals.ui.list.adapter.AnimalUiModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

class AnimalsViewModel
@Inject constructor(
    private val animalsRepository: AnimalsRepository
): ViewModel() {

    private val _animals = MutableLiveData<List<AnimalUiModel>>()

    val animals: LiveData<List<AnimalUiModel>>
        get() = _animals

    private val _error = MutableLiveData<String?>()

    val error: LiveData<String?>
        get() = _error

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        _error.postValue(exception.message)
        println(exception)
    }

    fun loadAnimals() = viewModelScope.launch(exceptionHandler) {
        val response = animalsRepository.loadAnimals()
        _animals.postValue(
            AnimalsMapper.mapAnimals(response)
        )
    }
}
