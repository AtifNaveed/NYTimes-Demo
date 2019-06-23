package com.atif.nytimes.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.atif.nytimes.application.App
import com.atif.nytimes.R
import com.atif.nytimes.model.News
import com.atif.nytimes.utils.Constant
import com.atif.nytimes.utils.Utils
import com.atif.nytimes.viewmodel.NewsViewModelAdapter
import com.atif.nytimes.viewmodel.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.reflect.Type

class NewsListActivity : AppCompatActivity() {
    // Lazy Inject ViewModel
    private val viewModel: ViewModel by viewModel()
    private var gsnObj: Gson? = null
    private var listType: Type? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)

        listType = object: TypeToken<ArrayList<News>>() {}.type
        gsnObj = Gson()

        val gsnList = App().getList(this)
        if (gsnList != Constant.news_list_key) {
            val newsArray = gsnObj?.fromJson(gsnList, listType) as ArrayList<News>
            setUpNewListView(newsArray)
        } else {
            callMostPopularNewsAPI(true)
        }
    }

    // API call to get most poplar news
    private fun callMostPopularNewsAPI(refresh : Boolean) {
        if (Utils.checkInternetReachability(this)) {
            viewModel.getNewsData(refresh,
                Constant.number_of_sections,
                Constant.period).observe(this, android.arch.lifecycle.Observer {
                val newsArray =  it?.getNewsArray()
                print(newsArray)

                val gsnString = gsnObj?.toJson(newsArray, listType)
                App().setList(this, gsnString!!)
                setUpNewListView(newsArray!!)
            })
        } else {
            Toast.makeText(applicationContext, getString(R.string.internet_reachability), Toast.LENGTH_SHORT).show()
        }
    }

    // Set up most poplar news list
    private fun setUpNewListView(newsArray: ArrayList<News>) {
        val listView = findViewById<ListView>(R.id.news_list)
        val listViewAdapter = NewsViewModelAdapter(this, newsArray)
        listView.adapter = listViewAdapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, view, position, _ ->
            val item = newsArray[position]
            val intent = Intent(view.context, NewsDetailActivity::class.java).apply {
                putExtra(Constant.new_object_key, item)
            }
            view.context.startActivity(intent)
        }
    }


}
