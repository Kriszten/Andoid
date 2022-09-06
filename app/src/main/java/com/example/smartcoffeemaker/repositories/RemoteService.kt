package com.example.smartcoffeemaker.repositories

import com.example.smartcoffeemaker.data.User

interface RemoteService {
    fun getUser(): User

    fun getProgramCount(): Int // TODO

    fun isLedTurnedOn(): Boolean // TODO

    fun switchLed() // TODO

}
