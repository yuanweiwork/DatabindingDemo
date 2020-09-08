package com.yww.demo02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yww.demo02.databinding.ActivityDemo04Binding

class Demo04Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityDemo04Binding>(
            this@Demo04Activity,
            R.layout.activity_demo_04
        )
    }
}