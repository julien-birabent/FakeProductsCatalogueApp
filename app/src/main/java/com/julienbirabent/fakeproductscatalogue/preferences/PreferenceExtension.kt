package com.julienbirabent.fakeproductscatalogue.preferences

import android.content.SharedPreferences
import com.julienbirabent.fakeproductscatalogue.preferences.delegate.BooleanPreference
import com.julienbirabent.fakeproductscatalogue.preferences.delegate.FloatPreference
import com.julienbirabent.fakeproductscatalogue.preferences.delegate.IntPreference
import com.julienbirabent.fakeproductscatalogue.preferences.delegate.StringPreference
import kotlin.properties.ReadWriteProperty

fun SharedPreferences.int(key: String, defaultValue: Int = 0): ReadWriteProperty<Any, Int> =
    IntPreference(this, key, defaultValue)

fun SharedPreferences.boolean(
    key: String,
    defaultValue: Boolean = false
): ReadWriteProperty<Any, Boolean> =
    BooleanPreference(this, key, defaultValue)

fun SharedPreferences.string(
    key: String,
    defaultValue: String? = null
): ReadWriteProperty<Any, String?> =
    StringPreference(this, key, defaultValue)

fun SharedPreferences.float(
    key: String,
    defaultValue: Float = 0.0f
): ReadWriteProperty<Any, Float> =
    FloatPreference(this, key, defaultValue)