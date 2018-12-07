package com.example.silvioallgayertrindade.avaliacaodev.data.repository

import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import com.example.silvioallgayertrindade.avaliacaodev.network.service.utils.CallbackListener

interface EventsRepository {
    suspend fun getEvents(callbackListener: CallbackListener<List<Event>>)
}