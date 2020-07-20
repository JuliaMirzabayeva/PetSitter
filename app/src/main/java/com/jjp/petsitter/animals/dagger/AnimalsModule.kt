package com.jjp.petsitter.animals.dagger

import com.jjp.petsitter.animals.repository.AnimalsApiService
import com.jjp.petsitter.animals.repository.AnimalsRepository
import com.jjp.petsitter.animals.repository.AnimalsRepositoryImpl
import com.jjp.petsitter.animals.ui.description.AnimalDescriptionMapper
import com.jjp.petsitter.animals.ui.description.AnimalDescriptionMapperImpl
import com.jjp.petsitter.animals.ui.list.AnimalsMapper
import com.jjp.petsitter.animals.ui.list.AnimalsMapperImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class AnimalsModule {

    companion object {

        @Provides
        fun provideAnimalsApiService(retrofit: Retrofit): AnimalsApiService {
            return retrofit.create(AnimalsApiService::class.java)
        }
    }

    @Binds
    @AnimalsScope
    abstract fun bindsAnimalsRepository(repository: AnimalsRepositoryImpl): AnimalsRepository

    @Binds
    abstract fun bindsAnimalsMapper(mapper: AnimalsMapperImpl): AnimalsMapper

    @Binds
    abstract fun bindsAnimalDescriptionMapper(mapper: AnimalDescriptionMapperImpl): AnimalDescriptionMapper
}
