package com.example.cleanarchitecturewithhilt.domain.repository

import com.example.cleanarchitecturewithhilt.core.common.Resource
import com.example.cleanarchitecturewithhilt.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    fun getAllCharacters(): Flow<Resource<List<Character>>>
}