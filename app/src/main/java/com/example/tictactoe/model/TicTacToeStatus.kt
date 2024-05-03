package com.example.tictactoe.model

// Función para determinar si hay un ganador en el juego Tic-Tac-Toe
fun TicTacToe.findWinner(): Winner? {
    return when {
        isWinner('X') -> Winner.X // Si 'X' es el ganador, devuelve Winner.X
        isWinner('O') -> Winner.O // Si 'X' es el ganador, devuelve Winner.X
        isBoardComplete() -> Winner.Draw // Si el tablero está completo y no hay ganador, devuelve Winner.Draw (empate)
        else -> null // Si no hay ganador ni tablero completo, devuelve null

    }
}
// Función privada para verificar si el tablero está completo (empate)
private fun TicTacToe.isBoardComplete(): Boolean {
    return board.flatten().none { it == ' ' }// El tablero está completo si no hay espacios vacíos (' ')
}
// Función privada para verificar si un jugador específico es el ganador
private fun TicTacToe.isWinner(player: Char): Boolean {
    // Verifica si alguna fila tiene todas las celdas ocupadas por el mismo jugador

    return board.any { row -> row.all { it == player } } ||
            // Verifica diagonales y columnas para determinar el ganador
            board[0][0] == player && board[1][1] == player && board[2][2] == player ||
            board[0][2] == player && board[1][1] == player && board[2][0] == player ||
            board[0][0] == player && board[1][0] == player && board[2][0] == player ||
            board[0][1] == player && board[1][1] == player && board[2][1] == player ||
            board[0][2] == player && board[1][2] == player && board[2][2] == player
}
