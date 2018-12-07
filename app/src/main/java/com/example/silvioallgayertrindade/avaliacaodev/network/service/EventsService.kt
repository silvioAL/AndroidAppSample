package com.example.silvioallgayertrindade.avaliacaodev.network.service

import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface EventsService{
    @GET("/events")
    fun getEvents(): Deferred<Response<List<Event>>>
}