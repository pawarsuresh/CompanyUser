package com.example.demo1.data.repository

import com.example.demo1.data.model.User
import com.example.demo1.data.remote.ApiInterface
import com.example.demo1.domian.repository.UserDetailRepository
import javax.inject.Inject

class UserDetailRepositoryImp @Inject constructor(private val apiInterface: ApiInterface) : UserDetailRepository {
    override suspend fun getUserDetail(user_id:Int): User {
        return apiInterface.getUserDetail(user_id)
    }
}