package com.rmakiyama.cap

import android.app.Application
import timber.log.Timber

class CapApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if(BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}
