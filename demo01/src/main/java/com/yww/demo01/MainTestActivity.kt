package com.yww.demo01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yww.demo01.databinding.ActivityMainTestBinding

class MainTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = DataBindingUtil.setContentView<ActivityMainTestBinding>(
            this,
            R.layout.activity_main_test
        )
        val user = User("01setUser")
        bind.apply {

            bind.bean = User("初始文字")

            btn1.setOnClickListener {
                bind.bean = user
            }

            btn2.setOnClickListener {
                user.name = "02修改"
            }

        }
    }
}