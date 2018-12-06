package com.example.silvioallgayertrindade.avaliacaodev.di.module

import android.arch.lifecycle.ViewModelProvider
import com.example.silvioallgayertrindade.avaliacaodev.factory.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}