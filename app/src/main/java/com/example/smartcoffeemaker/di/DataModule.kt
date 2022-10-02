package com.example.smartcoffeemaker.di

import com.example.smartcoffeemaker.repositories.RemoteRepository
import com.example.smartcoffeemaker.repositories.RemoteService
import com.example.smartcoffeemaker.repositories.RemoteServiceImplementation
import com.example.smartcoffeemaker.repositories.RepositorySource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    companion object {
        @Singleton
        @Provides
        fun provideRemoteRepository(remoteService: RemoteService): RepositorySource {
            return RemoteRepository(remoteService)
        }

        @Provides
        @Singleton
        fun provideRemoteService(): RemoteService {
            return RemoteServiceImplementation()
        }
    }
}