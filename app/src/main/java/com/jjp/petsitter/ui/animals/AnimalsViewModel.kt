package com.jjp.petsitter.ui.animals

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjp.petsitter.ui.animals.adapter.AnimalUiModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class AnimalsViewModel : ViewModel() {

    private val animalsLoader = AnimalsLoader()

    private val _animalsVO = MutableLiveData<List<AnimalUiModel>>()

    val animalsVO: LiveData<List<AnimalUiModel>>
        get() = _animalsVO

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println(exception)
    }

    fun loadAnimals() = viewModelScope.launch(exceptionHandler) {
        val response = animalsLoader.loadAnimals()
        _animalsVO.postValue(AnimalsMapper.mapAnimals(response.animals))
    }
}
