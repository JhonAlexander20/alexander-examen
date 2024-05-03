package com.example.tictactoe

import com.example.tictactoe.model.TicTacToe
import com.example.tictactoe.model.Winner
import com.example.tictactoe.model.findWinner
import org.junit.Assert.assertEquals
import org.junit.Test

class TicTacToeTest {

    @Test
    fun `when X plays in the top left corner, then X is in the top left corner`() {
        val ticTacToe = TicTacToe() // Crea una instancia de TicTacToe
        val newTicTacToe = ticTacToe.move(0, 0) // Realiza un movimiento de X en la posición (0, 0)
        assertEquals('X', newTicTacToe.board[0][0]) // Verifica que en la posición (0, 0) haya una 'X'
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner, then O is in the top right corner`() {
        val ticTacToe = TicTacToe()
        val newTicTacToe = ticTacToe.move(0, 0).move(0, 2) // X juega en (0, 0) y luego O juega en (0, 2)
        assertEquals('O', newTicTacToe.board[0][2]) // Verifica que en la posición (0, 2) haya una 'O'
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner and X plays in the top middle, then X is in the top middle`() {
        val ticTacToe = TicTacToe()
        val newTicTacToe = ticTacToe.move(0, 0).move(0, 2).move(0, 1)
        assertEquals('X', newTicTacToe.board[0][1])
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner and X plays in the top middle and O plays in the middle left, then O is in the middle left`() {
        val ticTacToe = TicTacToe()
        val newTicTacToe = ticTacToe.move(0, 0).move(0, 2).move(0, 1).move(1, 0)
        assertEquals('O', newTicTacToe.board[1][0])
    }

    @Test
    fun `when X plays in the top left corner and O plays in the top right corner and X plays in the top middle and O plays in the middle left and X plays in the top right, then X is the winner`() {
        val ticTacToe = TicTacToe()
        val newTicTacToe = ticTacToe
            .move(0, 0)
            .move(0, 2)
            .move(0, 1)
            .move(1, 0)
            .move(0, 2)

        assertEquals(Winner.X, newTicTacToe.findWinner()) // Verifica que X sea el ganador
    }
}