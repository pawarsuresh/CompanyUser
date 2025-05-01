package com.example.demo1.domian.repository

import com.example.demo1.data.model.User

interface UserRepository {
   suspend fun getUser() : List<User>
}