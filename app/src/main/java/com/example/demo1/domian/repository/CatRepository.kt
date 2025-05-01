package com.example.demo1.domian.repository

import com.example.demo1.data.model.CatFact

interface CatRepository {
    suspend fun getCatFact() : CatFact
}