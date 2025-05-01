package com.example.demo1.data.repository

import com.example.demo1.data.model.CatFact
import com.example.demo1.data.remote.CatInterface
import com.example.demo1.domian.repository.CatRepository
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(val catInterface: CatInterface)  : CatRepository{
    override suspend fun getCatFact(): CatFact {
        return  catInterface.getCatData()
    }
}