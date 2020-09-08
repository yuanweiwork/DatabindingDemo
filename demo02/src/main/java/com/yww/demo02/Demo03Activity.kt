package com.yww.demo02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.yww.demo02.databinding.ActivityDemo03Binding

//activity中使用
//
//fragment中使用
//
//view的绑定
//
//adapter中使用
class Demo03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityDemo03Binding>(
            this@Demo03Activity,
            R.layout.activity_demo_03
        )
    }
}
