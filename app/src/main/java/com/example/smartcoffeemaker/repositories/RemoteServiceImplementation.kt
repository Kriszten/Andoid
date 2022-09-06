package com.example.smartcoffeemaker.repositories

import com.example.smartcoffeemaker.data.User

class RemoteServiceImplementation : RemoteService {
    override fun getUser(): User {
        // TODO get Users from server
        // HTTP.get("api/users")...
        return User("Kriszten", 25) // dummy value for now
    }

    override fun isLedTurnedOn(): Boolean {
        // TODO get Led State from server
        // HTTP.get("api/ledState")...
        return true // dummy value for now
    }

    override fun switchLed() {
        // TODO post new Led State from server
        // HTTP.post("api/setLedState")...
        TODO("Not yet implemented")
    }

    override fun getProgramCount(): Int {
        TODO("Not yet implemented")
    }

}
