package com.example.smartcoffeemaker.repositories

import com.example.smartcoffeemaker.data.User

interface RepositorySource {
    suspend fun getUser(): Result<User>
    suspend fun getLedState(): Result<Boolean>
}