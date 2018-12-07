package com.example.silvioallgayertrindade.avaliacaodev.network.service.utils

interface CallbackListener<T>{
    fun onSuccess(response: T)
    fun onFailure(errorMessage: String)

}