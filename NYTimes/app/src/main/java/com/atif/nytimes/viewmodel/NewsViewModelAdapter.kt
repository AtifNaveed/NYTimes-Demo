package com.atif.nytimes.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.atif.nytimes.R
import com.atif.nytimes.model.News

class NewsViewModelAdapter(private val context: Context, private val listModelArrayList: ArrayList<News>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val vh: ViewHolder

        if (convertView == null) {
            val layoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.news_item, parent, false)
            vh = ViewHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as ViewHolder
        }

        vh.tvTitle.text = listModelArrayList[position].title
        vh.tvByLine.text = listModelArrayList[position].byline
        vh.tvPublishDate.text = listModelArrayList[position].published_date
        return view
    }

    override fun getItem(position: Int): Any {
        return listModelArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return listModelArrayList.size
    }
}

private class ViewHolder(view: View?) {
    val tvTitle: TextView = view?.findViewById(R.id.tv_title) as TextView
    val tvByLine: TextView = view?.findViewById(R.id.tv_byline) as TextView
    val tvPublishDate: TextView = view?.findViewById(R.id.tv_published_date) as TextView
}
