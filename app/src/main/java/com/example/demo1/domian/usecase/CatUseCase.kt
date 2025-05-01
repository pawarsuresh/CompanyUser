package com.example.demo1.domian.usecase

import com.example.demo1.data.model.CatFact
import com.example.demo1.domian.repository.CatRepository
import javax.inject.Inject

class CatUseCase @Inject constructor(private val catRepository: CatRepository)  {
    suspend operator fun invoke() : CatFact = catRepository.getCatFact()
}