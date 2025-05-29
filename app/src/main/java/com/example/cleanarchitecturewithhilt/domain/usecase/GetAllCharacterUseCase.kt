package com.example.cleanarchitecturewithhilt.domain.usecase

import com.example.cleanarchitecturewithhilt.domain.repository.CharacterRepository
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val repository: CharacterRepository) {
    operator fun invoke() = repository.getAllCharacters()
}