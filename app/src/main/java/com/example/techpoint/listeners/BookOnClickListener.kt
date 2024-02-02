package com.example.techpoint.listeners

import android.view.View
import com.example.techpoint.model.BookDataSet

interface BookOnClickListener {
    fun bookOnClick(view: View, manga: BookDataSet)
}