package com.example.silvioallgayertrindade.avaliacaodev.viewmodel

import android.arch.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import com.example.silvioallgayertrindade.avaliacaodev.data.repository.EventsRepository
import com.example.silvioallgayertrindade.avaliacaodev.network.service.utils.CallbackListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor(val repositoryImpl: EventsRepository) : ViewModel() {

    var eventsList = MutableLiveData<List<Event>>()
    var message = MutableLiveData<String>()

    init {
        message.value = ""
    }

    fun loadEvents() {

        GlobalScope.launch {

            repositoryImpl.getEvents(object : CallbackListener<List<Event>> {
                override fun onSuccess(response: List<Event>) {
                    eventsList.postValue(response)
                }

                override fun onFailure(errorMessage: String) {
                    message.postValue(errorMessage)
                }
            })

        }

    }

}