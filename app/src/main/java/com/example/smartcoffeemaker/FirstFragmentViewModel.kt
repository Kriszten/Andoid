package com.example.smartcoffeemaker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartcoffeemaker.data.User
import com.example.smartcoffeemaker.usecases.GetLedStateUseCase
import com.example.smartcoffeemaker.usecases.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstFragmentViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val getLedStateUseCase: GetLedStateUseCase,
) : ViewModel() {

    // Private access - mutableLiveData
    private val _users = MutableLiveData<User>()
    private val _isLedTurnedOn = MutableLiveData<Boolean>()

    // Public access - immutableLiveData
    val users: LiveData<User> = _users
    val isLedTurnedOn: LiveData<Boolean> = _isLedTurnedOn

    fun getUserData() {
        viewModelScope.launch {
            getUsersUseCase.invoke().onSuccess {
                _users.value = it
            }.onFailure {
                // TODO error handling if server returns error
            }
        }
    }

    fun getLedState() {
        viewModelScope.launch {
            getLedStateUseCase.invoke().onSuccess {
                _isLedTurnedOn.value = it
            }.onFailure {
                // TODO error handling if server returns error
            }
        }
    }

}