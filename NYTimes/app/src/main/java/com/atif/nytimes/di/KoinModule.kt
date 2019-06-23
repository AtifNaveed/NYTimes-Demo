package com.atif.nytimes.di

import com.atif.nytimes.api.ApiEndpoints
import com.atif.nytimes.viewmodel.ViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    single { ApiEndpoints() }
    viewModel{ ViewModel(get()) }
}