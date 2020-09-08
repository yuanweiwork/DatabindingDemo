package com.yww.demo04

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setTitle")
fun setText(view: TextView, name: String) {
    view.text = name
}

