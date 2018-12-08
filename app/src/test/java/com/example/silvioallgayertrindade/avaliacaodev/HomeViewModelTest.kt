package com.example.silvioallgayertrindade.avaliacaodev

import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import com.example.silvioallgayertrindade.avaliacaodev.data.repository.EventsRepository
import com.example.silvioallgayertrindade.avaliacaodev.network.service.utils.RepositoryListener
import com.example.silvioallgayertrindade.avaliacaodev.viewmodel.HomeFragmentViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.eq
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.spy
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HomeViewModelTest {

    @Mock
    lateinit var eventsRepository: EventsRepository
    @Mock
    lateinit var repositoryListener: RepositoryListener<List<Event>>

    lateinit var homeFragmentViewModel: HomeFragmentViewModel

    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()
    private fun <T> anyObject(): T {
        return Mockito.anyObject<T>()
    }
    private fun <T> any(): T {
        Mockito.any<T>()
        return uninitialized()
    }
    private fun <T> uninitialized(): T = null as T

    @Before
    fun setup() {
        initMocks(this)
        homeFragmentViewModel = HomeFragmentViewModel(eventsRepository)
    }

    private fun createEventsList(): List<Event> {
        val event = Event("", "title", "description", "10/10/2090")
        val list = listOf<Event>()
        list.plus(event)
        return list
    }

    @Test
    fun onLoadData_shouldRetrieveEventsDate() {

//        runBlocking {
//
//            homeFragmentViewModel.loadEvents()
//
//            Mockito.verify(eventsRepository).getEvents(homeFragmentViewModel.repositoryListener)
//
//        }

        runBlocking {

            homeFragmentViewModel.loadEvents()
            repositoryListener.onSuccess(createEventsList())
        }

    }

    @Test
    fun onLoadData_shouldRetrieveEventsTiltle() {
        homeFragmentViewModel.loadEvents()

    }

    @Test
    fun onLoadData_shouldRetrieveEventsDescription() {
        homeFragmentViewModel.loadEvents()

    }

    @Test
    fun onLoadData_gotFailure_shouldShowErrorMessage() {
    }

}