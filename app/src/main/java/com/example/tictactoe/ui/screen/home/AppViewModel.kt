package com.example.tictactoe.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.tictactoe.model.TicTacToe
import com.example.tictactoe.model.Winner
import com.example.tictactoe.model.findWinner

// ViewModel que maneja la lógica del juego de Tic-Tac-Toe
class AppViewModel : ViewModel() {
    // Estado mutable para la interfaz de usuario
    var state by mutableStateOf(UiState())
        private set
    // Método para iniciar un nuevo juego
    fun startGame() {
        state = UiState(
            ticTacToe = TicTacToe(),
            gameState = GameState.InProgress
        )
    }
    // Método para realizar un movimiento en el juego
    fun move(row: Int, column: Int) {
        val newTicTacToe = state.ticTacToe.move(row, column)
        state = UiState(
            ticTacToe = newTicTacToe,
            gameState = when (val winner = newTicTacToe.findWinner()) {
                null -> GameState.InProgress // Si no hay ganador, el juego está en progreso
                else -> GameState.Finished(winner) // Si hay ganador, el juego ha terminado
            }
        )
    }
}
// Estado de la interfaz de usuario
data class UiState(
    val ticTacToe: TicTacToe = TicTacToe(), // Estado actual del juego Tic-Tac-Toe
    val gameState: GameState = GameState.NotStarted // Estado del juego (No iniciado, En progreso, Finalizado)

)

sealed interface GameState {
    object NotStarted : GameState // Juego no iniciado
    object InProgress : GameState // Juego en progreso
    data class Finished(val winner: Winner) : GameState
    // Juego finalizado con un ganador
}