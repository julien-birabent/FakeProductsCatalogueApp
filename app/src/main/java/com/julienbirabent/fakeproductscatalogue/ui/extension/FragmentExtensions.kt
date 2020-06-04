package com.julienbirabent.fakeproductscatalogue.ui.extension

import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.julienbirabent.fakeproductscatalogue.R
import com.julienbirabent.fakeproductscatalogue.ui.adapter.ItemSelectionCallback

fun <T> createItemSelectionCallback(block: (T) -> Unit): ItemSelectionCallback<T> {
    return object : ItemSelectionCallback<T> {
        override fun onItemSelected(item: T) {
            block.invoke(item)
        }
    }
}

fun Fragment.showConfirmationDialog(
    title: String = "",
    message: String = "",
    positiveText: String,
    onConfirm: () -> Unit
) {
    MaterialAlertDialogBuilder(
        context,
        R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog_Centered
    )
        .setTitle(title)
        .setMessage(message)
        .setNegativeButton("Cancel") { dialog, which -> dialog.dismiss() }
        .setPositiveButton(positiveText) { dialog, which ->
            onConfirm.invoke()
            dialog.dismiss()
        }.setCancelable(true)
        .show()
}