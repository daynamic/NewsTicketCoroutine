package com.akshat.newsticketcoroutine.model

import retrofit2.http.GET
import com.akshat.newsticketcoroutine.model.NewsArticle

interface NewsService {
    @GET("news.json")
    suspend fun getNews(): List<NewsArticle>
}