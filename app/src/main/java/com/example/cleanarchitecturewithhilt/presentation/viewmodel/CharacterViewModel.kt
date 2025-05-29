package com.example.cleanarchitecturewithhilt.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturewithhilt.core.common.Resource
import com.example.cleanarchitecturewithhilt.domain.usecase.GetAllCharacterUseCase
import com.example.cleanarchitecturewithhilt.presentation.state.CharacterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val useCase: GetAllCharacterUseCase) :
    ViewModel() {
    private val _characterState = MutableStateFlow(CharacterState())
    val characterState: StateFlow<CharacterState>
        get() = _characterState

    init {
        getAllCharacters()
    }

    private fun getAllCharacters() {
        useCase().onEach {
            when (it) {
                is Resource.Loader -> {
                    _characterState.value = CharacterState().copy(loading = true)
                }

                is Resource.Success -> {
                    _characterState.value = CharacterState().copy(characters = it.data)
                }

                is Resource.Error -> {
                    _characterState.value = CharacterState().copy(errorMsg = it.msg)
                }
            }
        }.launchIn(viewModelScope)
    }
}