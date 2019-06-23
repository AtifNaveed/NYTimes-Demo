package com.atif.nytimes.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.atif.nytimes.R
import com.atif.nytimes.model.News
import com.atif.nytimes.utils.Constant
import kotlinx.android.synthetic.main.activity_news_detail.*

class NewsDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        val news = intent?.extras?.get(Constant.new_object_key) as News
        tv_title.text = news.title
        tv_detail.text = news.abstract

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpTo(this, Intent(this, NewsListActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
