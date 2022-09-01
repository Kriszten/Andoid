package repositories

import data.User

class UserRepository {
    fun getUser(): User {
        // TODO implement fetching Users from server
        return User("Kriszti", 25)
    }
}