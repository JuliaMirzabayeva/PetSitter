package com.jjp.petsitter

import android.app.Application

class App: Application() {

    companion object {
        private var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        getAppComponent().inject(this)
    }

    fun getAppComponent(): AppComponent {
        return appComponent ?: AppComponent.create().also {
            appComponent = it
        }
    }
}
