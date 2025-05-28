package com.example.cleanarchitecturewithhilt.data.mapper

import com.example.cleanarchitecturewithhilt.data.dto.CharacterDto
import com.example.cleanarchitecturewithhilt.domain.model.Character

fun CharacterDto.toDomainCharacter(): Character{
    return Character(actor,id,image,name)
}