package com.jjp.petsitter.animals.ui.description

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jjp.petsitter.animals.repository.AnimalsRepository
import kotlinx.coroutines.CoroutineExceptionHandler

class AnimalViewModel : ViewModel() {

    private val animalsRepository = AnimalsRepository()

    private val _animal = MutableLiveData<AnimalUiModel>()

    val animal: LiveData<AnimalUiModel>
        get() = _animal

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println(exception)
    }
}
