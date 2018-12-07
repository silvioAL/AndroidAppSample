package com.example.silvioallgayertrindade.avaliacaodev.data.repository

import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import com.example.silvioallgayertrindade.avaliacaodev.network.service.EventServiceApi
import com.example.silvioallgayertrindade.avaliacaodev.network.service.utils.CallbackListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class EventsRepositoryImpl @Inject constructor(
    val eventServiceApi: EventServiceApi
) : EventsRepository {

    override suspend fun getEvents(callbackListener: CallbackListener<List<Event>>) {
        val list = eventServiceApi.getEvents().await()
        if (list.isSuccessful) {
            list.body()?.let { callbackListener.onSuccess(it) }
        } else {
            list.message()?.let { callbackListener.onFailure(it) }
        }
    }
}