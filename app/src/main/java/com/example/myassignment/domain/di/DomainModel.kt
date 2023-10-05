package com.example.myassignment.domain.di

import com.example.myassignment.domain.repository.StatesRepository
import com.example.myassignment.domain.use_cases.GetStatesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DomainModel {

    @Provides
    fun provideGetStatesUseCase(statesRepository: StatesRepository): GetStatesUseCase {
        return GetStatesUseCase(statesRepository)
    }

}