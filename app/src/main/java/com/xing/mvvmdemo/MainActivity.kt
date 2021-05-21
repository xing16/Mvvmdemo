package com.xing.mvvmdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val mContext: Context = this
    private lateinit var homeViewModel: ApiHomeViewModel
    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tv_text)
        progressBar = findViewById(R.id.pb_loading)

        addObservers()
    }

    private fun addObservers() {
//        homeViewModel = ViewModelProvider(this, HomeViewModelFactory(application, "ext params"))
//            .get(ApiHomeViewModel::class.java).apply {
//                homeData.observe(this@MainActivity) {
//                    textView.text = it.items.toString()
//                }
//                loading.observe(this@MainActivity) {
//                    progressBar.visibility = if (it) View.VISIBLE else View.GONE
//                }
//            }
//        homeViewModel.fetchData("jetpack compose", 1, 15)
    }
}