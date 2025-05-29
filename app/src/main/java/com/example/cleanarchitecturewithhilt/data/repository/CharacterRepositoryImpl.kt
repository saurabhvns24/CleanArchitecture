package com.example.cleanarchitecturewithhilt.data.repository

import com.example.cleanarchitecturewithhilt.core.common.Resource
import com.example.cleanarchitecturewithhilt.data.api.CharacterApi
import com.example.cleanarchitecturewithhilt.data.mapper.toDomainCharacter
import com.example.cleanarchitecturewithhilt.domain.model.Character
import com.example.cleanarchitecturewithhilt.domain.repository.CharacterRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ViewModelScoped
class CharacterRepositoryImpl @Inject constructor(private val characterApi: CharacterApi) :
    CharacterRepository {
    override fun getAllCharacters(): Flow<Resource<List<Character>>> = flow {
        emit(Resource.Loader())
        val res = characterApi.getAllCharacters().map {
            it.toDomainCharacter()
        }
        emit(Resource.Success(res))
    }.flowOn(Dispatchers.IO).catch {
        emit(Resource.Error(it.message.toString()))
    }


}