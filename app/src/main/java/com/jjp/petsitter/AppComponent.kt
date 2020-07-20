package com.jjp.petsitter

import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Component(modules = [RetrofitModule::class])
@Singleton
interface AppComponent {

    companion object {

        private var appComponent: AppComponent? = null

        fun create(): AppComponent {
            return appComponent ?: DaggerAppComponent.create().also { appComponent = it }
        }
    }

    fun provideRetrofit(): Retrofit

    fun inject(app: App)
}
