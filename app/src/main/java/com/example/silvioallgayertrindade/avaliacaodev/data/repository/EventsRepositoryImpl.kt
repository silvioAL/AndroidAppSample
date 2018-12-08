package com.example.silvioallgayertrindade.avaliacaodev.data.repository

import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import com.example.silvioallgayertrindade.avaliacaodev.data.mapper.toEvent
import com.example.silvioallgayertrindade.avaliacaodev.data.remote.responsemodel.EventResponseModel
import com.example.silvioallgayertrindade.avaliacaodev.network.service.EventServiceApi
import com.example.silvioallgayertrindade.avaliacaodev.network.service.utils.RepositoryListener
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class EventsRepositoryImpl @Inject constructor(
    val eventServiceApi: EventServiceApi
) : EventsRepository, CoroutineScope {

    var errorMessage = ""
    private val job = Job()
    override val coroutineContext = job + Main
    lateinit var events: Response<List<EventResponseModel>>


    override fun getEvents(listener: RepositoryListener<List<Event>>) {

        launch {

            async {

                try {
                    events = eventServiceApi.getEvents().await()
                    if (events.isSuccessful && events.body() != null) {
                        listener.onSuccess(mapToLocal(events.body()))
                    }
                } catch (exception: Exception) {
                    errorMessage = exception.message.toString()
                    listener.onFailure(errorMessage)
                }
            }.await()
        }

    }

    private fun mapToLocal(remoteList: List<EventResponseModel>?): List<Event> {

        val localList = listOf<Event>()

        if (remoteList != null) {
            for (item in remoteList) {
                localList.plus(item.toEvent())
            }
        }

        return localList
    }
}