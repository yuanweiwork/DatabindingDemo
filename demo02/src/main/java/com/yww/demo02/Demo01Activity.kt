package com.yww.demo02

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yww.demo02.databinding.ActivityDemo01Binding

class Demo01Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDemo01Binding>(
            this@Demo01Activity,
            R.layout.activity_demo_01
        )
        binding.apply {
            val user = User("测试绑定实体类")
            binding.bean = user
        }

    }

}