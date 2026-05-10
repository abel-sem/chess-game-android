package com.example.chessgame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.chessgame.logic.GameManager
import com.example.chessgame.models.Move
import com.example.chessgame.models.PieceColor

@Composable
fun GameScreen() {
    val manager = remember { GameManager() }
    var selected by remember { mutableStateOf<Pair<Int, Int>?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Chess Game", style = MaterialTheme.typography.h5)
        Spacer(modifier = Modifier.height(16.dp))
        ChessboardUI(manager.board) { r, c ->
            val sel = selected
            if (sel == null) {
                if (manager.board.squares[r][c] != null && manager.board.squares[r][c]!!.color == manager.currentTurn) {
                    selected = Pair(r, c)
                }
            } else {
                val move = Move(sel.first, sel.second, r, c)
                if (manager.performMove(move)) selected = null
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Turn: ${manager.currentTurn}")
    }
}
