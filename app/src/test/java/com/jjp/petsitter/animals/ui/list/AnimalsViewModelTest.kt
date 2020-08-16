package com.jjp.petsitter.animals.ui.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.jjp.petsitter.TestCoroutineRule
import com.jjp.petsitter.animals.repository.AnimalsRepository
import com.jjp.petsitter.animals.ui.list.adapter.AnimalUiModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.lang.RuntimeException

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class AnimalsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var animalsRepository: AnimalsRepository

    @Mock
    lateinit var animalsObserver: Observer<List<AnimalUiModel>>

    @Mock
    lateinit var errorObserver: Observer<String?>

    private lateinit var animalsViewModel: AnimalsViewModel

    @Test
    fun `set animals after loading`() {
        testCoroutineRule.runBlockingTest {
            Mockito.`when`(animalsRepository.loadAnimals()).thenReturn(emptyList())

            animalsViewModel = AnimalsViewModel(animalsRepository)
            animalsViewModel.animals.observeForever(animalsObserver)

            animalsViewModel.loadAnimals()

            Mockito.verify(animalsRepository).loadAnimals()
            Mockito.verify(animalsObserver).onChanged(emptyList())
        }
    }

    @Test
    fun `show error after loading`() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Timeout exception"
            Mockito.`when`(animalsRepository.loadAnimals()).thenThrow(RuntimeException(errorMessage))

            animalsViewModel = AnimalsViewModel(animalsRepository)
            animalsViewModel.error.observeForever(errorObserver)

            animalsViewModel.loadAnimals()

            Mockito.verify(animalsRepository).loadAnimals()
            Mockito.verify(errorObserver).onChanged(errorMessage)
        }
    }
}
