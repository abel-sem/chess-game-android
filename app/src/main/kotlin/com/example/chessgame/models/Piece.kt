package com.example.chessgame.models

enum class PieceType { KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN }

enum class PieceColor { WHITE, BLACK }

open class Piece(val type: PieceType, val color: PieceColor)
