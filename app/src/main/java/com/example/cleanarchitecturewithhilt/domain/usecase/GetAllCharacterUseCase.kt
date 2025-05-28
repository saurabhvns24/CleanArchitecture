package com.example.cleanarchitecturewithhilt.domain.usecase

import com.example.cleanarchitecturewithhilt.domain.repository.CharacterRepository

class GetAllCharacterUseCase(private val repository: CharacterRepository) {
    operator fun invoke() = repository.getAllCharacters()
}