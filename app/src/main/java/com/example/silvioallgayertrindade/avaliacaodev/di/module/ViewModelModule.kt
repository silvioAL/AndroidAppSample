package com.example.silvioallgayertrindade.avaliacaodev.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.silvioallgayertrindade.avaliacaodev.di.annotation.ViewModelKey
import com.example.silvioallgayertrindade.avaliacaodev.factory.DaggerViewModelFactory
import com.example.silvioallgayertrindade.avaliacaodev.viewmodel.SingleActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SingleActivityViewModel::class)
    abstract fun bindSingleActivityViewModel(singleActivityViewModel: SingleActivityViewModel): ViewModel
}