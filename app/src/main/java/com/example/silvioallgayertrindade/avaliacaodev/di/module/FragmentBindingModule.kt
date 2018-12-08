package com.example.silvioallgayertrindade.avaliacaodev.di.module

import com.example.silvioallgayertrindade.avaliacaodev.di.scopes.ActivityScope
import com.example.silvioallgayertrindade.avaliacaodev.presentation.ui.fragment.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment
}