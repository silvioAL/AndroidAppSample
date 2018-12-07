package com.example.silvioallgayertrindade.avaliacaodev.network.service

import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class EventServiceApi @Inject constructor(val retrofit: Retrofit) {

    fun getEvents(): Deferred<Response<List<Event>>> {
        return retrofit.create(EventsService::class.java).getEvents()
    }
}