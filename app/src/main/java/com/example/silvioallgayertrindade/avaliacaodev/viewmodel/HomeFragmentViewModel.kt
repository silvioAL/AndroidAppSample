package com.example.silvioallgayertrindade.avaliacaodev.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Status
import com.example.silvioallgayertrindade.avaliacaodev.data.repository.EventsRepository
import com.example.silvioallgayertrindade.avaliacaodev.network.service.utils.RepositoryListener
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor(private val repositoryImpl: EventsRepository) : ViewModel() {

    var eventsList = MutableLiveData<List<Event>>()
    var message = MutableLiveData<String>()
    val status = MutableLiveData<Status>()

    init {
        message.value = ""
    }

    var listener = object : RepositoryListener<List<Event>> {
        override fun onSuccess(response: List<Event>) {
            status.value = Status.SUCCESS
            eventsList.postValue(response)
        }

        override fun onFailure(errorMessage: String) {
            status.value = Status.ERROR
            message.value = errorMessage
        }
    }

    fun loadEvents() {
        status.value = Status.LOADING
        repositoryImpl.getEvents(listener)
    }
}
