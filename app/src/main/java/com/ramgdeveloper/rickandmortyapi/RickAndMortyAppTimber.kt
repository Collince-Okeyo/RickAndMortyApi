package com.ramgdeveloper.rickandmortyapi

import android.app.Application
import timber.log.Timber

class RickAndMortyAppTimber: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }
    }
}