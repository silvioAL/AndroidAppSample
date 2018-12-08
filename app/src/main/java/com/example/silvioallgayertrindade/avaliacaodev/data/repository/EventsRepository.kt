package com.example.silvioallgayertrindade.avaliacaodev.data.repository

import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import com.example.silvioallgayertrindade.avaliacaodev.network.service.utils.RepositoryListener
import kotlinx.coroutines.Deferred

interface EventsRepository {
    fun getEvents(listener: RepositoryListener<List<Event>>)
}