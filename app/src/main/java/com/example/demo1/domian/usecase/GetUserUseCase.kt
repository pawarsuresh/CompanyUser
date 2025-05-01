package com.example.demo1.domian.usecase

import com.example.demo1.data.model.User
import com.example.demo1.domian.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke() : List<User> = userRepository.getUser()
}