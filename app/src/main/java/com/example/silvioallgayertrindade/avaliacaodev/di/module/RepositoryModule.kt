package com.example.silvioallgayertrindade.avaliacaodev.di.module

import com.example.silvioallgayertrindade.avaliacaodev.data.repository.EventsRepository
import com.example.silvioallgayertrindade.avaliacaodev.data.repository.EventsRepositoryImpl
import com.example.silvioallgayertrindade.avaliacaodev.network.service.EventServiceApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {

    @Provides
    @JvmStatic
    @Singleton
    fun provideEventsRepository(eventServiceApi: EventServiceApi): EventsRepository {
        return EventsRepositoryImpl(eventServiceApi)
    }

}