package com.example.cleanarchitecturewithhilt.data.api

import com.example.cleanarchitecturewithhilt.data.dto.CharacterDto
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getAllCharacters(): List<CharacterDto>
}