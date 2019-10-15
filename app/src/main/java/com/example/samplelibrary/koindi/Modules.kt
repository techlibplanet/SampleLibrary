package com.example.samplelibrary.koindi

import com.example.samplelibrary.helper.SharedPreferenceProvider
import org.koin.dsl.module

val myModule =
    module(override = true){
        single<SharedPreferenceProvider> {
            SharedPreferenceProvider(get())
        }

        factory<SharedPreferenceProvider> {
            SharedPreferenceProvider(get())
        }
    }