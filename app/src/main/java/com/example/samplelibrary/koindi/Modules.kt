package com.example.samplelibrary.koindi

import com.example.samplelibrary.helper.SharedPreferenceProvider
import com.example.samplelibrary.viewmodel.TestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myModule =
    module(override = true){
        single<SharedPreferenceProvider> {
            SharedPreferenceProvider(get())
        }

        factory<SharedPreferenceProvider> {
            SharedPreferenceProvider(get())
        }

        viewModel { TestViewModel(get()) }
    }