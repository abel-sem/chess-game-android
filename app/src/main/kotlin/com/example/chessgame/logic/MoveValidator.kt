package com.example.chessgame.logic

import com.example.chessgame.models.Board
import com.example.chessgame.models.Move

object MoveValidator {
    fun isValid(board: Board, move: Move): Boolean {
        // Very basic: ensure move is inside board and source has piece
        if (move.fromRow !in 0..7 || move.toRow !in 0..7) return false
        if (move.fromCol !in 0..7 || move.toCol !in 0..7) return false
        val piece = board.squares[move.fromRow][move.fromCol] ?: return false
        // disallow capturing own piece
        val dest = board.squares[move.toRow][move.toCol]
        if (dest != null && dest.color == piece.color) return false
        // more rules to implement
        return true
    }
}
