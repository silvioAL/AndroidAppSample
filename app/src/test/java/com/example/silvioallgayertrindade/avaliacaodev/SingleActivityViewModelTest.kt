package com.example.silvioallgayertrindade.avaliacaodev

import com.example.silvioallgayertrindade.avaliacaodev.presentation.view.SingleActivityView
import com.example.silvioallgayertrindade.avaliacaodev.viewmodel.SingleActivityViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SingleActivityViewModelTest {

    val singleActivityViewModel = SingleActivityViewModel()

    @Mock
    lateinit var singleActivityView: SingleActivityView

    @Before
    fun setup() {
        initMocks(this)
    }

    @Test
    fun onSetup_shouldExecuteNavigationAction() {
        singleActivityViewModel.setup(singleActivityView)
        verify(singleActivityView).executeInitialNavigationAction()
    }

}