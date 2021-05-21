package com.xing.mvvmdemo.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.xing.mvvmdemo.HomeViewModelFactory
import com.xing.mvvmdemo.R
import kotlinx.coroutines.Dispatchers

class HomeActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        textView = findViewById(R.id.tv_res)
        viewModel = ViewModelProvider(this, HomeViewModelFactory(HomeUseCase(HomeRepository(HomeDataSource()), Dispatchers.IO), "parameters")).get(HomeViewModel::class.java)
        viewModel.homeRepos.observe(this) {
            textView.text = it.toString()
        }
        viewModel.searchHomeRepos("mvvm", 1, 20)
    }
}