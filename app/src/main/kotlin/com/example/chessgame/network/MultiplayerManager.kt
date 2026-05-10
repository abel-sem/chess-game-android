package com.example.chessgame.network

import com.example.chessgame.models.Move

// Placeholder for real networked multiplayer
class MultiplayerManager {
    suspend fun createGame(): String { return "game-id-placeholder" }
    suspend fun joinGame(gameId: String) { }
    suspend fun sendMove(move: Move) { }
    suspend fun receiveMove(): Move? { return null }
}
