package com.xing.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import com.xing.mvvmdemo.sample.viewmodel.SavedStateHandleViewModel

class TestViewModelActivity : AppCompatActivity() {

    /**
     *  1. ViewModel 中使用 SavedStateHandle(使用ktx)
     *  或不用 ktx : val viewModel1:SavedStateHandleViewModel = ViewModelProvider(this,SavedStateViewModelFactory(application,this)).get(SavedStateHandleViewModel::class.java)
     */
    val viewModel: SavedStateHandleViewModel by viewModels {
        SavedStateViewModelFactory(application, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_view_model)


    }
}