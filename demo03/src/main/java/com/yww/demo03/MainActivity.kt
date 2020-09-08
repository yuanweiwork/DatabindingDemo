package com.yww.demo03

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.yww.demo03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var fragment: MainFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragment = MainFragment()


        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)


        binding.apply {
            binding.bean = User("MainActivity")
            mainFragment.setOnClickListener {
                supportFragmentManager.beginTransaction().add(R.id.root, fragment!!, "tag").commit()
            }
            mainAdapter.setOnClickListener {
                startActivity(Intent(this@MainActivity, AdapterActivity::class.java))
            }
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK && !fragment!!.isHidden) {
            supportFragmentManager.beginTransaction().remove(fragment!!).commit()
            true
        } else super.onKeyDown(keyCode, event)
    }


}
