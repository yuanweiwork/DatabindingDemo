package com.yww.demo03

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.yww.demo03.databinding.ActivityAdapterBinding

class AdapterActivity : AppCompatActivity() {
    var list: MutableList<User> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addListData()
        val bind = DataBindingUtil.setContentView<ActivityAdapterBinding>(
            this@AdapterActivity,
            R.layout.activity_adapter
        )
        bind.apply {
            rvList.layoutManager = LinearLayoutManager(this@AdapterActivity)
            rvList.adapter = MainAdapter(list)
        }
    }

    private fun addListData() {
        for (i in 1..40) {
            list.add(User("第${i}个"))
        }
    }
}