package com.app1.comparacionstring

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_setText() = runTest {
        launch {
            viewModel.setText("hola", 1)
            viewModel.setText("chau", 2)
        }
        advanceUntilIdle()

        val value1 = viewModel.getText1()
        val value2 = viewModel.getText2()
        assertEquals("hola", value1)
        assertEquals("chau", value2)
    }

    @Test
    fun mainViewModel_compara_valores_iguales() = runTest {
        launch {

            viewModel.setText("hola", 1)
            viewModel.setText("hola", 2)

            viewModel.compara()
        }
        advanceUntilIdle()

        val value = viewModel.texto.value?.resultado
        assertEquals(true, value)

    }

    @Test
    fun mainViewModel_compara_valores_distintos() = runTest {
        launch {

            viewModel.setText("hola", 1)
            viewModel.setText("dsasda", 2)

            viewModel.compara()
        }
        advanceUntilIdle()

        val value = viewModel.texto.value?.resultado
        assertEquals(false, value)

    }



}