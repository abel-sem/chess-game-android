package com.example.chessgame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chessgame.models.Board

@Composable
fun ChessboardUI(board: Board, onSquareClick: (Int, Int) -> Unit) {
    Column {
        for (r in 0..7) {
            Row {
                for (c in 0..7) {
                    val dark = (r + c) % 2 == 1
                    val color = if (dark) Color(0xFF769656) else Color(0xFFF0D9B5)
                    Box(modifier = Modifier.size(40.dp).background(color).clickable { onSquareClick(r, c) }) {
                        val piece = board.squares[r][c]
                        if (piece != null) {
                            Text(piece.type.name.take(1))
                        }
                    }
                }
            }
        }
    }
}
