package com.xing.mvvmdemo.wan

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.xing.mvvmdemo.R
import com.xing.mvvmdemo.base.Result
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class WanActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var progressBar: ProgressBar

    private lateinit var viewModel: WanViewModel
    private lateinit var viewModel2: WanViewModel2

    /*
    private val viewModel: WanViewModel by viewModels()
    private val viewModel1 = ViewModelProvider(this).get(WanViewModel::class.java)
    private val viewModel12 = ViewModelProvider(this, WanViewModelFactory(WanUseCase(Dispatchers.IO), "parameters")).get(WanViewModel::class.java)
    */

    /**
     * koin inject
     */
    private val viewModel3: WanViewModel2 by viewModel()   // viewModel() 是 koin 提供的扩展方法


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
        viewModel3.articles.observe(this) {
            if (it is Result.Loading) {
                progressBar.visibility = View.VISIBLE
            } else if (it is Result.Error) {
                progressBar.visibility = View.GONE
                textView2.text = it.exception.toString()
            } else {
                progressBar.visibility = View.GONE
                textView2.text = it.toString()
            }
        }
        viewModel3.getArticleList(0)


    }
}