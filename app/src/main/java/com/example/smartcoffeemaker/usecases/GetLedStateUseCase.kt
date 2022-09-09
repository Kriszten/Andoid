package com.example.smartcoffeemaker.usecases

import com.example.smartcoffeemaker.repositories.RepositorySource
import javax.inject.Inject

class GetLedStateUseCase @Inject constructor(private val repository: RepositorySource) {
    suspend fun invoke() = repository.getLedState()
}
