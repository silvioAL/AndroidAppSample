package com.example.silvioallgayertrindade.avaliacaodev.di.module

import com.example.silvioallgayertrindade.avaliacaodev.di.scopes.ActivityScope
import com.example.silvioallgayertrindade.avaliacaodev.presentation.ui.activity.SingleActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindSingleActivity(): SingleActivity
}