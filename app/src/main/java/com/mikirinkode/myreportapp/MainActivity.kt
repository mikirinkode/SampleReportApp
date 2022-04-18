package com.mikirinkode.myreportapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.crashlytics.FirebaseCrashlytics

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val crashButton = findViewById<Button>(R.id.btn_crash)
        crashButton.setOnClickListener {
            // create log to easier for track the error
            FirebaseCrashlytics.getInstance().log("Clicked on button")
            // if want to sending data like remain ram to firebase
            FirebaseCrashlytics.getInstance().setCustomKey("str_key", "some_data")
            // simulate the crash
            throw RuntimeException("Test Crash")
        }
    }
}