package com.example.chessgame.logic

import com.example.chessgame.models.Board
import com.example.chessgame.models.Move
import com.example.chessgame.models.PieceColor

class GameManager {
    val board = Board()
    var currentTurn: PieceColor = PieceColor.WHITE

    fun performMove(move: Move): Boolean {
        if (!MoveValidator.isValid(board, move)) return false
        val res = board.movePiece(move)
        if (res) currentTurn = if (currentTurn == PieceColor.WHITE) PieceColor.BLACK else PieceColor.WHITE
        return res
    }
}
