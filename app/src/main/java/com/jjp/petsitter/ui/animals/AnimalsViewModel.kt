package com.jjp.petsitter.ui.animals

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jjp.petsitter.ui.animals.adapter.AnimalVO
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class AnimalsViewModel : ViewModel() {

    private val animalsLoader = AnimalsLoader()

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println(exception)
    }

    val animalsVO = MutableLiveData<List<AnimalVO>>()

    fun loadAnimals() = viewModelScope.launch(exceptionHandler) {
        val response = animalsLoader.loadAnimals()
        animalsVO.postValue(AnimalsMapper.mapAnimals(response.animals))
    }
}
