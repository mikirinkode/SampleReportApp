package com.mikirinkode.myreportapp

import android.app.Application
import com.mikirinkode.myreportapp.utils.ReleaseTree
import timber.log.Timber

open class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        /*
            Timber initialisation using .plant()
            with parameter Tree (which is a thing that you want to record)
         */
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(ReleaseTree())
        }
    }
}