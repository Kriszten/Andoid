package com.example.smartcoffeemaker.usecases

import com.example.smartcoffeemaker.repositories.RepositorySource
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: RepositorySource) {
    suspend fun invoke() = repository.getUser()
}
