package com.example.demo1.domian.usecase

import com.example.demo1.data.model.User
import com.example.demo1.domian.repository.UserDetailRepository
import javax.inject.Inject

class GetUserDetailUseCase @Inject constructor(private val userDetailRepository: UserDetailRepository) {
    suspend operator fun invoke(userid:Int) : User = userDetailRepository.getUserDetail(userid)
}