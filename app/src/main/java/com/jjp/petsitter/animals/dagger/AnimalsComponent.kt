package com.jjp.petsitter.animals.dagger

import com.jjp.petsitter.AppComponent
import com.jjp.petsitter.FeatureScope
import com.jjp.petsitter.animals.ui.description.AnimalDescriptionFragment
import com.jjp.petsitter.animals.ui.list.AnimalsFragment
import dagger.Component


@Component(
    dependencies = [AppComponent::class],
    modules = [AnimalsModule::class, AnimalsViewModelModule::class]
)
@FeatureScope
interface AnimalsComponent {

    companion object {
        fun create(appComponent: AppComponent): AnimalsComponent {
            return DaggerAnimalsComponent.builder().appComponent(appComponent).build()
        }
    }

    fun inject(animalsFragment: AnimalsFragment)

    fun inject(animalDescriptionFragment: AnimalDescriptionFragment)
}
