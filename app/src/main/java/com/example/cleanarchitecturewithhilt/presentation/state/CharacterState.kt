package com.example.cleanarchitecturewithhilt.presentation.state

import com.example.cleanarchitecturewithhilt.domain.model.Character

data class CharacterState(
    val characters: List<Character>? = emptyList<Character>(),
    val errorMsg: String? = "",
    val loading: Boolean = false
)