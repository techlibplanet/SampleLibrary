package com.example.samplelibrary.viewmodel

import androidx.lifecycle.ViewModel
import com.example.samplelibrary.helper.SharedPrefKeys.FIRST_NAME
import com.example.samplelibrary.helper.SharedPrefKeys.LAST_NAME
import com.example.samplelibrary.helper.SharedPreferenceProvider

class TestViewModel(
    private val sharedPreferenceProvider: SharedPreferenceProvider
) : ViewModel() {

    fun saveData(firstName: String, lastName: String) {
        sharedPreferenceProvider.putPref(FIRST_NAME, firstName)
        sharedPreferenceProvider.putPref(LAST_NAME, lastName)
    }

    fun getData(): String {
        return sharedPreferenceProvider.getPref(
            FIRST_NAME,
            ""
        ) + " " + sharedPreferenceProvider.getPref(LAST_NAME, "")
    }

}