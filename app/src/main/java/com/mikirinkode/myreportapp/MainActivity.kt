package com.mikirinkode.myreportapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.crashlytics.FirebaseCrashlytics
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
            adding timber
            timber enhanced Log, which will be non activated automatically when releasing app
            if you still want to show log when release mode
            create custom ReleaseTree. more detail see class on package utils
         */
        Timber.d("Test Debugging")

        val crashButton = findViewById<Button>(R.id.btn_crash)
        crashButton.setOnClickListener {
            // create log to easier for track the error
            FirebaseCrashlytics.getInstance().log("Clicked on button")
            // if want to sending data like remain ram to firebase
            FirebaseCrashlytics.getInstance().setCustomKey("str_key", "some_data")
            // simulate the crash
            try {
                throw RuntimeException("Test Crash")
            } catch (e: Exception){
                Timber.e("Test non fatal exception")
            }
        }
    }
}