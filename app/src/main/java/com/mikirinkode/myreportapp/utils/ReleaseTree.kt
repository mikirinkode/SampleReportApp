package com.mikirinkode.myreportapp.utils

import android.util.Log
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

/*
    if you want to show log on release mode
    simply create your own Custom Tree
    like below
 */
class ReleaseTree: Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR || priority == Log.WARN){
            if (t == null){
                FirebaseCrashlytics.getInstance().log(message)
            } else {
                // recordException used to send error message to Firebase Crashlytics
                FirebaseCrashlytics.getInstance().recordException(t)
            }
        }
    }
}