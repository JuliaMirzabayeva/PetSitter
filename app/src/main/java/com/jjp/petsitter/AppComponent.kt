package com.jjp.petsitter

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])
@Singleton
interface AppComponent {

    companion object {

        fun create(): AppComponent {
            return DaggerAppComponent.create()
        }
    }

    fun provideRetrofit(): Retrofit

    fun inject(app: App)
}
