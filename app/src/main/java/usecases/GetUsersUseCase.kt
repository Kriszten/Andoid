package usecases

import repositories.UserRepository

class GetUsersUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke() = userRepository.getUser()
}
