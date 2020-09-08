package com.yww.demo04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yww.demo04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val name: String = "测试Adapter"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityMainBinding>(
            this@MainActivity,
            R.layout.activity_main
        ).apply {
            activity = this@MainActivity
        }
    }

}