package com.julienbirabent.fakeproductscatalogue.preferences

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(sharedPreferences: SharedPreferences) {

    var hasCatalogueBeenUploaded: Boolean by sharedPreferences.boolean(
        "hasCatalogueBeenUploaded",
        false
    )
}
