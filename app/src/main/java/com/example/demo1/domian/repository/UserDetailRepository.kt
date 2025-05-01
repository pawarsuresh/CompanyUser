package com.example.demo1.domian.repository

import com.example.demo1.data.model.User

interface UserDetailRepository {
    suspend fun getUserDetail(user_id:Int) : User
}