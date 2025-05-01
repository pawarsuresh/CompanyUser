package com.example.demo1.data.repository

import com.example.demo1.data.model.User
import com.example.demo1.data.remote.ApiInterface
import com.example.demo1.domian.repository.UserRepository
import jakarta.inject.Named
import javax.inject.Inject

class UserRepositoryImp @Inject constructor(private val apiInterface: ApiInterface) : UserRepository  {
    override suspend fun getUser(): List<User> {
        return apiInterface.getUser()
    }
}