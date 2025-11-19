package com.example.apiconnectionpractice.ui.viewmodel

import com.example.apiconnectionpractice.data.model.products.Products
import com.example.apiconnectionpractice.data.model.user.DataModel
import com.example.apiconnectionpractice.data.model.user.UsersModel
import com.example.apiconnectionpractice.repository.product.ProductApiRepository
import com.example.apiconnectionpractice.repository.user.UserApiRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class UsersViewModelTest {
    private val testDispatcher = StandardTestDispatcher()

    private lateinit var userViewModel: UsersViewModel
    private lateinit var productApiRepository: ProductApiRepository
    private lateinit var userApiRepository: UserApiRepository

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        userApiRepository = mock(UserApiRepository::class.java)
        productApiRepository = mock(ProductApiRepository::class.java)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchUsers updates state with data`() = runTest {
        // Arrange
        val users = UsersModel(
            data = listOf(DataModel(firstName = "John", lastName = "Doe"))
        )

        `when`(userApiRepository.getAllUsers()).thenReturn(users)
        `when`(productApiRepository.getAllProducts()).thenReturn(Products())

        // Create ViewModel AFTER mocks
        userViewModel = UsersViewModel(userApiRepository, productApiRepository)

        // Act
        advanceUntilIdle()

        // Assert
        assertEquals(users.data, userViewModel.userData.value?.data)
        verify(userApiRepository).getAllUsers()
    }

}