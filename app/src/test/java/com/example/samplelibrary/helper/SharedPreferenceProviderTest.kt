package com.example.samplelibrary.helper

import android.app.Application
import android.content.SharedPreferences
import com.example.samplelibrary.R
import com.example.samplelibrary.helper.SharedPrefKeys.EMAIL
import com.example.samplelibrary.koindi.myModule
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.isA
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mockito.mock

class SharedPreferenceProviderTest : KoinTest {

    private val sharedPreferenceProvider: SharedPreferenceProvider by inject()
    val mockedAndroidContext = mock(Application::class.java)
    val sharedPreferences: SharedPreferences = mock()


    @Before
    fun before() {
        startKoin {
            androidContext(mockedAndroidContext)
            modules(myModule)
        }
    }

    @After
    fun after() {
        stopKoin()
    }


    @Test
    fun putStringInPreferenceAndGetPreferenceValues() {
        val editor: SharedPreferences.Editor = mock()
        assertNotNull(sharedPreferenceProvider)
        whenever(mockedAndroidContext.getString(R.string.preference_file_key)).thenReturn("SharedPref")
        whenever(sharedPreferences.edit()).thenReturn(editor)
        whenever(sharedPreferences.getString(EMAIL, "")).thenReturn("mayank@gmail.com")

        whenever(mockedAndroidContext.getSharedPreferences(eq("SharedPref"), isA())).thenReturn(
            sharedPreferences
        )

        sharedPreferenceProvider.putPref(EMAIL, "mayank@gmail.com")

        val actual = sharedPreferenceProvider.getPref(EMAIL, "")

        assertEquals("mayank@gmail.com", actual)
    }

    @Test
    fun putBooleanInPreferenceAndGetPreferenceValues() {
        val editor: SharedPreferences.Editor = mock()
        assertNotNull(sharedPreferenceProvider)
        whenever(mockedAndroidContext.getString(R.string.preference_file_key)).thenReturn("SharedPref")
        whenever(sharedPreferences.edit()).thenReturn(editor)
        whenever(sharedPreferences.getBoolean(EMAIL,false)).thenReturn(true)

        whenever(mockedAndroidContext.getSharedPreferences(eq("SharedPref"), isA())).thenReturn(
            sharedPreferences
        )

        sharedPreferenceProvider.putPref(EMAIL, true)

        val actual = sharedPreferenceProvider.getPref(EMAIL, false)

        assertTrue(actual)
    }

    @Test
    fun putFloatInPreferenceAndGetPreferenceValues() {
        val floatValue= 1.5f
        val editor: SharedPreferences.Editor = mock()
        assertNotNull(sharedPreferenceProvider)
        whenever(mockedAndroidContext.getString(R.string.preference_file_key)).thenReturn("SharedPref")
        whenever(sharedPreferences.edit()).thenReturn(editor)
        whenever(sharedPreferences.getFloat(EMAIL,0.0f)).thenReturn(floatValue)

        whenever(mockedAndroidContext.getSharedPreferences(eq("SharedPref"), isA())).thenReturn(
            sharedPreferences
        )

        sharedPreferenceProvider.putPref(EMAIL, floatValue)

        val actual = sharedPreferenceProvider.getPref(EMAIL, 0.0f)

        assertEquals(floatValue,actual)
    }

    @Test
    fun putIntInPreferenceAndGetPreferenceValues() {
        val intValue= 1
        val editor: SharedPreferences.Editor = mock()
        assertNotNull(sharedPreferenceProvider)
        whenever(mockedAndroidContext.getString(R.string.preference_file_key)).thenReturn("SharedPref")
        whenever(sharedPreferences.edit()).thenReturn(editor)
        whenever(sharedPreferences.getInt(EMAIL,0)).thenReturn(intValue)

        whenever(mockedAndroidContext.getSharedPreferences(eq("SharedPref"), isA())).thenReturn(
            sharedPreferences
        )

        sharedPreferenceProvider.putPref(EMAIL, intValue)

        val actual = sharedPreferenceProvider.getPref(EMAIL, 0)

        assertEquals(intValue,actual)
    }

    @Test
    fun putLongInPreferenceAndGetPreferenceValues() {
        val longValue= 1L
        val editor: SharedPreferences.Editor = mock()
        assertNotNull(sharedPreferenceProvider)
        whenever(mockedAndroidContext.getString(R.string.preference_file_key)).thenReturn("SharedPref")
        whenever(sharedPreferences.edit()).thenReturn(editor)
        whenever(sharedPreferences.getLong(EMAIL,0L)).thenReturn(longValue)

        whenever(mockedAndroidContext.getSharedPreferences(eq("SharedPref"), isA())).thenReturn(
            sharedPreferences
        )

        sharedPreferenceProvider.putPref(EMAIL, longValue)

        val actual = sharedPreferenceProvider.getPref(EMAIL, 0L)

        assertEquals(longValue,actual)
    }

    @Test
    fun getPreferenceValues_ThrowsErrorIfTypeIsNotValid() {
        val error=Throwable("Type is not valid.").toString()
        val editor: SharedPreferences.Editor = mock()
        assertNotNull(sharedPreferenceProvider)
        whenever(mockedAndroidContext.getString(R.string.preference_file_key)).thenReturn("SharedPref")
        whenever(sharedPreferences.edit()).thenReturn(editor)
        whenever(sharedPreferences.getString(EMAIL,"")).thenReturn(error)

        whenever(mockedAndroidContext.getSharedPreferences(eq("SharedPref"), isA())).thenReturn(
            sharedPreferences
        )
        val actual = sharedPreferenceProvider.getPref(EMAIL, "")
        assertEquals(error,actual)
    }



    @Test
    fun removePreference() {
        val editor: SharedPreferences.Editor = mock()
        assertNotNull(sharedPreferenceProvider)
        whenever(mockedAndroidContext.getString(R.string.preference_file_key)).thenReturn("SharedPref")
        whenever(sharedPreferences.edit()).thenReturn(editor)
        whenever(editor.remove(isA())).thenReturn(editor)
        whenever(sharedPreferences.getString(EMAIL, "")).thenReturn("mayank@gmail.com")

        whenever(mockedAndroidContext.getSharedPreferences(eq("SharedPref"), isA())).thenReturn(
            sharedPreferences
        )

        sharedPreferenceProvider.putPref(EMAIL, "mayank@gmail.com")

        val email = sharedPreferenceProvider.getPref(EMAIL, "")

        assertEquals("mayank@gmail.com", email)

        sharedPreferenceProvider.removePref(EMAIL)

        whenever(sharedPreferences.getString(EMAIL, "")).thenReturn("")

        val afterRemovePrefEmail = sharedPreferenceProvider.getPref(EMAIL, "")

        assertEquals("", afterRemovePrefEmail)
    }

    @Test
    fun clearAllPreference() {
        val editor: SharedPreferences.Editor = mock()
        assertNotNull(sharedPreferenceProvider)
        whenever(mockedAndroidContext.getString(R.string.preference_file_key)).thenReturn("SharedPref")
        whenever(sharedPreferences.edit()).thenReturn(editor)
        whenever(editor.clear()).thenReturn(editor)
        whenever(sharedPreferences.getString(EMAIL, "")).thenReturn("mayank@gmail.com")

        whenever(mockedAndroidContext.getSharedPreferences(eq("SharedPref"), isA())).thenReturn(
            sharedPreferences
        )

        sharedPreferenceProvider.putPref(EMAIL, "mayank@gmail.com")

        val email = sharedPreferenceProvider.getPref(EMAIL, "")

        assertEquals("mayank@gmail.com", email)

        sharedPreferenceProvider.clearPrefs()

        whenever(sharedPreferences.getString(EMAIL, "")).thenReturn("")

        val afterRemovePrefEmail = sharedPreferenceProvider.getPref(EMAIL, "")

        assertEquals("", afterRemovePrefEmail)
    }

}