package com.example.myassignment.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myassignment.data.common.Resources
import com.example.myassignment.domain.use_cases.GetStatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getStatesUseCase: GetStatesUseCase) :
    ViewModel() {

    val list = MutableStateFlow(StatesListState())

    init {
        getStates()
    }

    private fun getStates() {
        getStatesUseCase().onEach {
            when (it) {
                is Resources.Loading -> {
                    list.value = StatesListState(isLoading = true)
                }

                is Resources.Success -> {
                    list.value = StatesListState(data = it.data)
                }

                is Resources.Error -> {
                    list.value = StatesListState(error = it.message)
                }
            }
        }.launchIn(viewModelScope)
    }

}