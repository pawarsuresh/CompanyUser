package com.example.demo1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo1.data.model.User
import com.example.demo1.domian.usecase.GetUserDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(val getUserDetailUseCase: GetUserDetailUseCase) : ViewModel(){
    val userDetail = MutableStateFlow<User?>(null)
    fun getUserDetail(user_Id: Int){
        viewModelScope.launch {
            userDetail.value = getUserDetailUseCase(user_Id)
        }
    }
}