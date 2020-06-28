package com.jjp.petsitter.animals.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jjp.petsitter.ViewModelFactory
import com.jjp.petsitter.ViewModelKey
import com.jjp.petsitter.animals.ui.description.AnimalDescriptionViewModel
import com.jjp.petsitter.animals.ui.list.AnimalsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AnimalsViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AnimalsViewModel::class)
    abstract fun animalsViewModel(viewModel: AnimalsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AnimalDescriptionViewModel::class)
    abstract fun animalDescriptionViewModel(viewModel: AnimalDescriptionViewModel): ViewModel
}
