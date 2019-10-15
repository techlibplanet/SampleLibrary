package com.example.samplelibrary.helper

import android.app.Application
import android.content.Context
import com.example.samplelibrary.R
import com.example.samplelibrary.helper.SharedPrefKeys.EMAIL
import com.example.samplelibrary.koindi.myModule
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.koin.test.inject
import org.mockito.Mockito.mock

class SharedPreferenceProviderTest : KoinTest {

    private val sharedPreferenceProvider: SharedPreferenceProvider by inject()
    val mockedAndroidContext = mock(Application::class.java)
    

    @Test
    fun checkModules() {
        startKoin {
            androidContext(mockedAndroidContext)
            modules(myModule)
        }

    }
}