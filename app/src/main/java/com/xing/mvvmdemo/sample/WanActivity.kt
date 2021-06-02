package com.xing.mvvmdemo.sample

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.xing.mvvmdemo.MainApplication
import com.xing.mvvmdemo.R
import com.xing.mvvmdemo.http.Result
import com.xing.mvvmdemo.http.data
import com.xing.mvvmdemo.sample.viewmodel.BasicViewModel
import com.xing.mvvmdemo.sample.viewmodel.StateFlowViewModel
import com.xing.mvvmdemo.sample.viewmodel.LiveDataViewModel
import com.xing.mvvmdemo.sample.viewmodel.factory.WanViewModelFactory
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.ext.android.viewModel

class WanActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var progressBar: ProgressBar

    private lateinit var viewModel2: LiveDataViewModel

    // basic ViewModel
//    private val viewModel: BasicViewModel by viewModels()
//    private val viewModel1 = ViewModelProvider(this).get(BasicViewModel::class.java)
//    private val viewModel11 = ViewModelProvider(this, WanViewModelFactory("parameters")).get(BasicViewModel::class.java)

    /**
     * koin inject
     */
    private val liveDataViewModel: LiveDataViewModel by viewModel()   // viewModel() 是 koin 提供的扩展方法
    private val flowViewModel: StateFlowViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wan)
        textView = findViewById(R.id.tv_result)
        textView2 = findViewById(R.id.tv_result2)
        progressBar = findViewById(R.id.loading)
//        viewModel = ViewModelProvider(this, WanViewModelFactory(WanUseCase(Dispatchers.IO), "parameters")).get(WanViewModel::class.java)
//        viewModel.articleList.observe(this) {
//            textView.text = it.toString()
//        }
//        viewModel.getArticle(0)


//        viewModel3 = ViewModelProvider(this, WanViewModelFactory2(WanRepository(WanDataSource()))).get(WanViewModel2::class.java)
        liveDataViewModel.articles.observe(this) {
            it?.let { result ->
                when (result) {
                    is Result.Loading -> {
                        // show progress
                        progressBar.visibility = View.VISIBLE
                    }
                    is Result.Error -> {
                        // handle error
                        progressBar.visibility = View.GONE
                        Toast.makeText(MainApplication.context, result.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                    is Result.Success -> {
                        // show success result
                        progressBar.visibility = View.GONE
                    }
                }
                result.data?.let { data: ArticleData ->
                    // show result
                    textView2.text = data.toString()
                }
            }
        }
        // request remote api
        liveDataViewModel.getArticleList(0)



        flowViewModel.list.asLiveData().observe(this) {

        }
        flowViewModel.getList(0)

    }
}