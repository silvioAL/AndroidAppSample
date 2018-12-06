package com.example.silvioallgayertrindade.avaliacaodev.di.module

import com.example.silvioallgayertrindade.avaliacaodev.data.repository.EventsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {

    @Provides
    @JvmStatic
    @Singleton
    fun provideEventsRepository(): EventsRepository {
        return EventsRepository()
    }

}