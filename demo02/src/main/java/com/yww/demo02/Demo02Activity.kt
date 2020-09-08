package com.yww.demo02

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yww.demo02.databinding.ActivityDemo02Binding

class Demo02Activity : AppCompatActivity(), MyClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDemo02Binding>(
            this@Demo02Activity,
            R.layout.activity_demo_02
        )
        binding.apply {
            click = this@Demo02Activity
            viewModel = ViewModel()
        }

    }

    override fun click(name: String) {
        Toast.makeText(applicationContext, "输入框输入:$name", Toast.LENGTH_LONG).show()
    }
}