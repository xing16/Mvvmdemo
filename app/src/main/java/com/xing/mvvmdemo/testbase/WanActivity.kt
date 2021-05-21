package com.xing.mvvmdemo.testbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.xing.mvvmdemo.R

class WanActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private val viewModel: WanViewModel by viewModels()
    private val viewModel1 = ViewModelProvider(this).get(WanViewModel::class.java)
    private val viewModel2 = ViewModelProvider(this, WanViewModelFactory(application, WanRepository(), "params")).get(WanViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wan)
        textView = findViewById(R.id.tv_result)
        viewModel.banners.observe(this) {
            textView.text = it.toString()
        }
    }
}