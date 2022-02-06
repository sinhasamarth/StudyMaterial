package com.github.sinhasamarth.studymaterial.di

import com.github.sinhasamarth.studymaterial.MainViewModel
import com.github.sinhasamarth.studymaterial.Repository
import com.github.sinhasamarth.studymaterial.api.RetrofitInstance
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single { RetrofitInstance }
    single { MainViewModel() }
    single { Repository() }
}