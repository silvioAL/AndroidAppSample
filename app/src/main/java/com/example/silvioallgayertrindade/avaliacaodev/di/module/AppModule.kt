package com.example.silvioallgayertrindade.avaliacaodev.di.module

import android.app.Application
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindApplication(app: Application): Application

}