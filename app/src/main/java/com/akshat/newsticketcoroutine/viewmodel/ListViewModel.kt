package com.akshat.newsticketcoroutine.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.akshat.newsticketcoroutine.model.NewsRepository

class ListViewModel : ViewModel() {

    val newsArticles = NewsRepository().getNewsArticles().asLiveData()

}