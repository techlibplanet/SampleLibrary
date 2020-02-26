package com.example.samplelibrary

import android.app.Application
import com.example.samplelibrary.koindi.myMandirModule
import com.example.samplelibrary.koindi.myModule
import com.example.samplelibrary.koindi.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SampleLibraryApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SampleLibraryApplication)
            androidLogger()
            modules(listOf(myModule, retrofitModule, myMandirModule))
        }
    }
}