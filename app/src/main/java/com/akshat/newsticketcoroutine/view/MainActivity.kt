package com.akshat.newsticketcoroutine.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshat.newsticketcoroutine.R
import com.akshat.newsticketcoroutine.viewmodel.ListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val newsListAdapter = NewsListAdapter()
    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var newsList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        newsList = findViewById(R.id.newsList)
        progressBar = findViewById(R.id.loading_view)

        viewModel = ViewModelProvider(this)[ListViewModel::class.java]

        newsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsListAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.newsArticles.observe(this, Observer { article ->
            progressBar.visibility = View.GONE
            newsList.visibility = View.VISIBLE
            newsListAdapter.onAddNewsItem(article)
            newsList.smoothScrollToPosition(0)
        })
    }


}