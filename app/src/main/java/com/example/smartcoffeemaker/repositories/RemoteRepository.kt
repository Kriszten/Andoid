package com.example.smartcoffeemaker.repositories

import com.example.smartcoffeemaker.data.User
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val remoteService: RemoteService) :
    RepositorySource {
    override suspend fun getUser(): Result<User> {
        // TODO implement fetching Users from server
        return runCatching {
            remoteService.getUser()
        }
    }

    override suspend fun getLedState(): Result<Boolean> {
        return runCatching {
            remoteService.isLedTurnedOn()
        }
    }
}