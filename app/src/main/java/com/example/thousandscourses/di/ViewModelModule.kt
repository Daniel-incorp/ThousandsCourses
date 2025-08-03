package com.example.thousandscourses.di

import com.example.feature_login.viewmodel.LoginViewModel
import com.example.feature_main.viewmodel.AccountViewModel
import com.example.feature_main.viewmodel.FavoritesViewModel
import com.example.feature_main.viewmodel.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel() }
    viewModel { HomeViewModel(get()) }
    viewModel { FavoritesViewModel(get()) }
    viewModel { AccountViewModel() }
}
