package com.example.silvioallgayertrindade.avaliacaodev.service

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EventsService{
    @GET("/events")
    fun getEvents()
}