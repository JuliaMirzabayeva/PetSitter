package com.jjp.petsitter.animals.dagger

import com.jjp.petsitter.AppComponent
import com.jjp.petsitter.animals.ui.description.AnimalDescriptionFragment
import com.jjp.petsitter.animals.ui.list.AnimalsFragment
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [AnimalsModule::class, AnimalsViewModelModule::class]
)
@AnimalsScope
interface AnimalsComponent {

    companion object {

        private var animalsComponent: AnimalsComponent? = null

        fun create(appComponent: AppComponent): AnimalsComponent {
            return animalsComponent ?: DaggerAnimalsComponent
                .builder()
                .appComponent(appComponent)
                .build()
                .also { animalsComponent = it }
        }
    }

    fun inject(animalsFragment: AnimalsFragment)

    fun inject(animalDescriptionFragment: AnimalDescriptionFragment)
}
