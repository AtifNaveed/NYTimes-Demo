package com.atif.nytimes.application

import android.app.Activity
import android.app.Application
import android.content.Context
import com.atif.nytimes.di.appModule
import com.atif.nytimes.utils.Constant
import org.koin.android.ext.android.startKoin

class App : Application() {

    private val newsArray = "newsArray"
    init { instance = this }

    companion object {
        private var instance: App? = null
        fun context() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }

    fun setList(activity: Activity, key: String) {
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(newsArray, key)
        editor.apply()
    }

    fun getList(activity: Activity): String? {
        val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
        return sharedPref.getString(newsArray, Constant.news_list_key)
    }

}