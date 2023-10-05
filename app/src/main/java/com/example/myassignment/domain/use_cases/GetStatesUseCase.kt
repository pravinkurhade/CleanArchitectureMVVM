package com.example.myassignment.domain.use_cases

import com.example.myassignment.data.common.Resources
import com.example.myassignment.domain.model.Countries
import com.example.myassignment.domain.repository.StatesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetStatesUseCase(private val statesRepository: StatesRepository) {
    operator fun invoke(): Flow<Resources<Countries>> = flow {
        emit(Resources.Loading())
        try {
            emit(Resources.Success(data = statesRepository.getStates()))
        } catch (e: Exception) {
            emit(Resources.Error(message = e.message))
        }
    }
}