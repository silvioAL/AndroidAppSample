package com.example.silvioallgayertrindade.avaliacaodev

import android.arch.lifecycle.Observer
import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Event
import com.example.silvioallgayertrindade.avaliacaodev.data.local.domainmodel.Status
import com.example.silvioallgayertrindade.avaliacaodev.data.repository.EventsRepository
import com.example.silvioallgayertrindade.avaliacaodev.network.service.utils.RepositoryListener
import com.example.silvioallgayertrindade.avaliacaodev.viewmodel.HomeFragmentViewModel
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers
import org.mockito.ArgumentMatchers.any
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations.initMocks
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HomeViewModelTest {

    @Mock
    lateinit var messageObserver: Observer<String>

    @Mock
    lateinit var eventsRepository: EventsRepository

    @Captor
    lateinit var listenerCaptor: ArgumentCaptor<RepositoryListener<List<Event>>>

    fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()

    lateinit var homeFragmentViewModel: HomeFragmentViewModel

    @Before
    fun setup() {
        initMocks(this)
        homeFragmentViewModel = HomeFragmentViewModel(eventsRepository)
        homeFragmentViewModel.message.observeForever(messageObserver)
    }

    private fun createEventsList(): List<Event> {
        val event = Event("", "title", "description", "10/10/2090")
        val list = listOf<Event>()
        list.plus(event)
        return list
    }

    @Test
    fun onLoadingData_shouldSetLoadingState() {
        runBlocking {
            homeFragmentViewModel.loadEvents()
            assertThat(homeFragmentViewModel.status.value, `is`(Status.LOADING))

        }
    }

    @Test
    fun onLoadingFinish_success_shouldUpdateLoadingState() {
        runBlocking {
            homeFragmentViewModel.loadEvents()
            homeFragmentViewModel.listener.onSuccess(createEventsList())
            assertThat(homeFragmentViewModel.status.value, `is`(Status.SUCCESS))
        }
    }

    @Test
    fun onLoadingFinish_error_shouldUpdateLoadingStateToError() {
        runBlocking {
            homeFragmentViewModel.loadEvents()
            homeFragmentViewModel.listener.onFailure("")
            assertThat(homeFragmentViewModel.status.value, `is`(Status.ERROR))
        }
    }

    @Test
    fun onLoadingFinish_error_shouldUpdateErrorMessage() {
        runBlocking {
            homeFragmentViewModel.loadEvents()
            homeFragmentViewModel.listener.onFailure("error")
            verify(messageObserver).onChanged("error")
        }
    }

    @Test
    fun onLoading_success_shouldUpdateDataValue() {

        runBlocking {
            homeFragmentViewModel.loadEvents()
            verify(eventsRepository).getEvents(capture(listenerCaptor))
            listenerCaptor.value.onSuccess(createEventsList())
            assertThat(homeFragmentViewModel.eventsList.value, `is`(createEventsList()))

        }
    }

}