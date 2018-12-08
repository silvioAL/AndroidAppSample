package com.example.silvioallgayertrindade.avaliacaodev.network.service.utils

interface RepositoryListener<T>{
    fun onSuccess(response: T)
    fun onFailure(errorMessage: String)
}