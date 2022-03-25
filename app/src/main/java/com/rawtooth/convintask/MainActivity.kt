package com.rawtooth.convintask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.rawtooth.convintask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: Adapter
    var number = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        number = mutableListOf<Int>(1)
        adapter = Adapter(this, number)
        binding.recycleView.adapter = adapter
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.refersh.setOnRefreshListener(this)
    }

    override fun onRefresh() {
        var i = number.last()
        i++
        number.add(i)
        adapter.notifyDataSetChanged()
        binding.refersh.isRefreshing = false
    }
}