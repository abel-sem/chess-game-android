package com.example.chessgame.models

class Board {
    // 8x8 board, null = empty
    val squares: Array<Array<Piece?>> = Array(8) { Array<Piece?>(8) { null } }

    init {
        setupInitial()
    }

    fun setupInitial() {
        // simplified initial setup: pawns + kings for demo
        for (i in 0..7) {
            squares[1][i] = Piece(PieceType.PAWN, PieceColor.BLACK)
            squares[6][i] = Piece(PieceType.PAWN, PieceColor.WHITE)
        }
        squares[0][4] = Piece(PieceType.KING, PieceColor.BLACK)
        squares[7][4] = Piece(PieceType.KING, PieceColor.WHITE)
    }

    fun movePiece(move: Move): Boolean {
        val piece = squares[move.fromRow][move.fromCol] ?: return false
        squares[move.toRow][move.toCol] = piece
        squares[move.fromRow][move.fromCol] = null
        return true
    }
}
