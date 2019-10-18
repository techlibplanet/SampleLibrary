package com.example.samplelibrary.helper

import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import com.example.samplelibrary.R

object SharedPrefKeys {
    const val FIRST_NAME = "first_name"
    const val LAST_NAME = "last_name"
    const val EMAIL = "email"
}

class SharedPreferenceProvider(private val context: Context) {
    private val defaultSharedPreferences: SharedPreferences
        get() {
            return context.getSharedPreferences(
                context.getString(R.string.preference_file_key),
                Context.MODE_PRIVATE
            )
        }

    fun clearPrefs() {
        applyPref(prefEditor().clear())
    }

    fun <T> putPref(key: String, value: T) {
        val editor = prefEditor()
        applyPref(addToPrefEditor(editor, key, value))
    }

    fun <T> addToPrefEditor(
        editor: SharedPreferences.Editor,
        key: String,
        value: T
    ): SharedPreferences.Editor {
        when (value) {
            is String -> editor.putString(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Float -> editor.putFloat(key, value)
            is Int -> editor.putInt(key, value)
            is Long -> editor.putLong(key, value)
            else -> throw Throwable("Type is not valid.")
        }
        return editor
    }

    fun removePref(key: String) {
        applyPref(prefEditor().remove(key))
    }

    fun <T> getPref(key: String, defaultValue: T): T {
        val prefs = this.defaultSharedPreferences
        val value: Any? = when (defaultValue) {
            is String -> prefs.getString(key, defaultValue)
            is Boolean -> prefs.getBoolean(key, defaultValue)
            is Float -> prefs.getFloat(key, defaultValue)
            is Int -> prefs.getInt(key, defaultValue)
            is Long -> prefs.getLong(key, defaultValue)
            else -> throw Throwable("Type is not valid.")
        }
        return value as T
    }

    fun prefEditor(): SharedPreferences.Editor = defaultSharedPreferences.edit()


    fun applyPref(editor: SharedPreferences.Editor) {
        when {
            Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD -> editor.commit()
            else -> editor.apply()
        }
    }
}