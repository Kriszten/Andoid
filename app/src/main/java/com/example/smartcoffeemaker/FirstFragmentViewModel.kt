package com.example.smartcoffeemaker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import data.User
import kotlinx.coroutines.launch
import repositories.UserRepository
import usecases.GetUsersUseCase
import javax.inject.Inject

@HiltViewModel
class FirstFragmentViewModel @Inject constructor (val getUsersUseCase: GetUsersUseCase, val userRepository: UserRepository) : ViewModel() {
    // Private access - mutableLiveData!
    private val _users = MutableLiveData<ArrayList<User>>()

    // Public access - immutableLiveData
    val users: LiveData<ArrayList<User>> = _users


    fun getData() {
        viewModelScope.launch {
//            getUsersUseCase.invoke() {  ->
//                _users.value = users
//            }.onFailure {
//                // error handling
//            }
            userRepository.getUser()
        }
    }

}