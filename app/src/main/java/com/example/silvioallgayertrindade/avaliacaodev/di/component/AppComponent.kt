package com.example.silvioallgayertrindade.avaliacaodev.di.component

import com.example.silvioallgayertrindade.avaliacaodev.MainApplication
import com.example.silvioallgayertrindade.avaliacaodev.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton

@Component(modules = [AndroidSupportInjectionModule::class,
    ActivityBindingModule::class,
    AppModule::class,
    RepositoryModule::class,
    ApiModule::class,
    ViewModelModule::class])
interface AppComponent: AndroidInjector<MainApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(mainApplication:MainApplication): AppComponent.Builder

        fun build(): AppComponent
    }
}