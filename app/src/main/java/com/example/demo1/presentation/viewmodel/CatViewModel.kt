package com.example.demo1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demo1.data.model.CatFact
import com.example.demo1.domian.usecase.CatUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatViewModel @Inject constructor(val catUseCase: CatUseCase) : ViewModel() {

    private val _catFacts = MutableStateFlow<List<CatFact>>(emptyList())
    val catFacts: StateFlow<List<CatFact>> = _catFacts.asStateFlow()


    fun fetchRandomDogImage() {
        viewModelScope.launch {
            val fact = catUseCase()
            _catFacts.value = _catFacts.value + fact
            }
    }

}