package com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel

import com.google.gson.annotations.SerializedName

class Event constructor(
    @SerializedName("image") val image: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("date") val date: String
)