package com.example.chessgame.logic

import com.example.chessgame.models.Board
import com.example.chessgame.models.Move
import com.example.chessgame.models.PieceColor
import kotlin.random.Random

class AIPlayer(val color: PieceColor) {

    fun pickMove(board: Board, difficulty: Difficulty): Move? {
        return when (difficulty) {
            Difficulty.EASY -> pickRandom(board)
            Difficulty.MEDIUM -> pickRandom(board) // stub: implement better logic
            Difficulty.HARD -> pickRandom(board) // stub: implement minimax
        }
    }

    private fun pickRandom(board: Board): Move? {
        val moves = mutableListOf<Move>()
        for (r in 0..7) for (c in 0..7) {
            val piece = board.squares[r][c] ?: continue
            if (piece.color != color) continue
            // naive: try all destinations
            for (tr in 0..7) for (tc in 0..7) {
                val m = Move(r, c, tr, tc)
                if (MoveValidator.isValid(board, m)) moves.add(m)
            }
        }
        if (moves.isEmpty()) return null
        return moves[Random.nextInt(moves.size)]
    }

    enum class Difficulty { EASY, MEDIUM, HARD }
}
