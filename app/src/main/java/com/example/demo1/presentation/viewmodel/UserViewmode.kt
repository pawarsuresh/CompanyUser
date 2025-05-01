package com.example.demo1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo1.data.model.User
import com.example.demo1.domian.usecase.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewmodel @Inject constructor(val getUserUseCase: GetUserUseCase): ViewModel(){
    val user = MutableStateFlow<List<User>>(emptyList())

    init {
        fetchUser()
    }

    fun fetchUser(){
        viewModelScope.launch {
            user.value = getUserUseCase()
        }
    }
}