package com.example.silvioallgayertrindade.avaliacaodev.data.remote.responsemodel

import com.google.gson.annotations.SerializedName

class EventResponseModel constructor(
    @SerializedName("image") val image: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("date") val date: String
)