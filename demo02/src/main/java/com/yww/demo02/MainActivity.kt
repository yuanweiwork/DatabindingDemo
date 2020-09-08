package com.yww.demo02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_bean.setOnClickListener {
            startActivity(Intent(this@MainActivity, Demo01Activity::class.java))
        }
        btn_click.setOnClickListener {
            startActivity(Intent(this@MainActivity, Demo02Activity::class.java))
        }
        btn_utils.setOnClickListener {
            startActivity(Intent(this@MainActivity, Demo03Activity::class.java))
        }
        btn_other.setOnClickListener {
            startActivity(Intent(this@MainActivity, Demo04Activity::class.java))
        }
    }
}
