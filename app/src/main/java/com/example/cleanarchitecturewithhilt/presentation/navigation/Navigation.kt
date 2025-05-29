package com.example.cleanarchitecturewithhilt.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cleanarchitecturewithhilt.presentation.components.CharacterScreen
import com.example.cleanarchitecturewithhilt.presentation.viewmodel.CharacterViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = CharactersScreen.CharacterScreen.route) {
        composable(CharactersScreen.CharacterScreen.route) {
            val characterViewModel = hiltViewModel<CharacterViewModel>()
            val characterState =
                characterViewModel.characterState.collectAsStateWithLifecycle().value
            CharacterScreen(modifier = Modifier, characterState = characterState)
        }
    }
}