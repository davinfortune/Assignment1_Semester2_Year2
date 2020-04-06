package org.wit.festivalapp.helpers

import android.app.Activity
import android.content.Intent
import org.wit.festivalapp.R


    fun showImagePicker(parent: Activity, id: Int) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_OPEN_DOCUMENT
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        val chooser = Intent.createChooser(intent, R.string.select_artist_image.toString())
        parent.startActivityForResult(chooser, id)
    }
