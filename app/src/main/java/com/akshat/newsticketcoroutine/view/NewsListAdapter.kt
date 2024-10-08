package com.akshat.newsticketcoroutine.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.akshat.newsticketcoroutine.R
import com.akshat.newsticketcoroutine.model.NewsArticle

class NewsListAdapter: RecyclerView.Adapter<NewsListAdapter.NewsItemViewHolder>() {
    private val newsItems = arrayListOf<NewsArticle>()

    fun onAddNewsItem(item: NewsArticle) {
        newsItems.add(0, item)
        notifyItemInserted(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = NewsItemViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_news_article, parent, false)
    )

    override fun getItemCount() = newsItems.size

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        holder.bind(newsItems[position])
    }

    class NewsItemViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageView = view.findViewById<ImageView>(R.id.newsImage)
        private val author =view.findViewById<TextView>(R.id.newsAuthor)
        private val title = view.findViewById<TextView>(R.id.newsTitle)
        private val publishedAt = view.findViewById<TextView>(R.id.newsPublishedAt)

        fun bind(newsItem: NewsArticle) {
            imageView.loadImage(newsItem.urlToImage)
            author.text = newsItem.author
            title.text = newsItem.title
            publishedAt.text = newsItem.publishedAt
        }
    }
}