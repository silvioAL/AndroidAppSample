package com.example.silvioallgayertrindade.avaliacaodev.data.mapper

import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import com.example.silvioallgayertrindade.avaliacaodev.data.remote.responsemodel.EventResponseModel

fun EventResponseModel.toEvent() = Event(image, title, description, date)
