package com.example.cleanarchitecturewithhilt.presentation.navigation

sealed class CharactersScreen(val route: String) {
    object CharacterScreen: CharactersScreen("character_screen")

}