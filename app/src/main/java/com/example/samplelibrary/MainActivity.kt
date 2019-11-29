package com.example.samplelibrary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.samplelibrary.viewmodel.TestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // Lazy injected SharedPreferenceProvider
//    private val sharedPreferenceProvider by inject<SharedPreferenceProvider>()


    //    private lateinit var model : TestViewModel
//     Injected by lazy
    val model by viewModel<TestViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//         If you are not injecting by lazy then assign it in onCreate
//        model = getViewModel<TestViewModel>()


//        sharedPreferenceProvider.putPref(SharedPrefKeys.FIRST_NAME, "Mayank")
//        sharedPreferenceProvider.putPref(SharedPrefKeys.LAST_NAME, "Sharma")

//        model.firstName = sharedPreferenceProvider.getPref(SharedPrefKeys.FIRST_NAME, "")
//        model.lastName = sharedPreferenceProvider.getPref(SharedPrefKeys.LAST_NAME, "")

        model.saveData("Mayank", "Shilpa")

        Log.d("TAG", model.getData())


    }
}
