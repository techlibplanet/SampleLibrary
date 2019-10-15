package com.example.samplelibrary

import android.content.Context
import com.example.samplelibrary.helper.SharedPreferenceProvider
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.get
import org.mockito.Mockito.mock

class CheckModuleTest : KoinTest {

    @Test
    fun checkAllModules() {

        val mockModule = module {
            single {
                SharedPreferenceProvider(get())
            }
            single { mock(Context::class.java) }
        }

        startKoin { mockModule }

        assertNotNull(mockModule)


    }
}