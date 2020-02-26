package com.example.samplelibrary.koindi

import com.example.samplelibrary.viewmodel.MyMandirViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myMandirModule = module {
    viewModel {
        MyMandirViewModel(get())
    }
}