package com.example.silvioallgayertrindade.avaliacaodev.viewmodel

import android.arch.lifecycle.ViewModel
import com.example.silvioallgayertrindade.avaliacaodev.network.service.EventServiceApi
import com.example.silvioallgayertrindade.avaliacaodev.presentation.view.SingleActivityView
import javax.inject.Inject

class SingleActivityViewModel @Inject constructor() : ViewModel() {

    fun setup(singleActivityView: SingleActivityView) {
        singleActivityView.executeInitialNavigationAction()
    }
}