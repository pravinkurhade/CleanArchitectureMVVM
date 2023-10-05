package com.example.myassignment.presentation.main

import com.example.myassignment.domain.model.Countries

data class StatesListState(
    val isLoading: Boolean = false,
    val error: String? = "",
    val data: Countries? = null
)
