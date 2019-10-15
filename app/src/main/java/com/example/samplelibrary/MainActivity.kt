package com.example.samplelibrary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.samplelibrary.helper.SharedPrefKeys
import com.example.samplelibrary.helper.SharedPreferenceProvider
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    // Lazy injected SharedPreferenceProvider
    private val sharedPreferenceProvider by inject<SharedPreferenceProvider>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferenceProvider.putPref(SharedPrefKeys.EMAIL, "mayank@gmail.com")

        val email = sharedPreferenceProvider.getPref(SharedPrefKeys.EMAIL, "")

        Log.d("Email", email)
    }
}
