package com.android.foodease.common.utils

import android.app.Activity
import android.widget.EditText
import android.widget.Toast

fun Activity.getEditTextValue(id: Int): String {
    return findViewById<EditText>(id).text.toString()
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
