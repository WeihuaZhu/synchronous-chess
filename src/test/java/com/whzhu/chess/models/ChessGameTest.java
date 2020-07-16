package com.whzhu.chess.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class ChessGameTest {

  private ChessGame game;

  @BeforeEach
  public void setUp() throws Exception {
    Player whitePlayer = new Player(1, "p1");
    Player blackPlayer = new Player(2, "p2");
    game = new ChessGame(whitePlayer, blackPlayer);
  }

  @Test
  public void testStartingPieces() throws Exception {
    Assertions.assertEquals(16, game.getAliveBlackPieces().size());
    Assertions.assertEquals(16, game.getAliveWhitePieces().size());
  }

  @Test
  public void testOpeningMoves() throws Exception {
    Assertions.assertTrue(game.makeMove(game.chessBoard[1][3], 3, 3)); // white queen's pawn opening
    Assertions.assertTrue(game.makeMove(game.chessBoard[6][4], 4, 4)); // black king's pawn opening
    ChessPiece blackKingPawn = game.chessBoard[4][4];
    Assertions.assertTrue(
        game.makeMove(game.chessBoard[3][3], 4, 4)); // white pawn capture black pawn
    Assertions.assertFalse(blackKingPawn.isAlive());
    Assertions.assertFalse(game.getAliveBlackPieces().contains(blackKingPawn));
    Assertions.assertEquals(15, game.getAliveBlackPieces().size());
  }

  @Test
  public void testIncorrectStarterPlayer() throws Exception {
    Assertions.assertFalse(game.makeMove(game.chessBoard[6][1], 5, 1));
  }

  @Test
  // TODO update this test when implemented checkmate won logic
  public void testFourMoveCheckMate() throws Exception {
    Assertions.assertTrue(game.makeMove(game.chessBoard[1][4], 3, 4));
    Assertions.assertTrue(game.makeMove(game.chessBoard[6][4], 4, 4));
    Assertions.assertTrue(game.makeMove(game.chessBoard[0][5], 3, 2));
    Assertions.assertTrue(game.makeMove(game.chessBoard[7][5], 4, 2));
    Assertions.assertTrue(game.makeMove(game.chessBoard[0][3], 4, 7));
    Assertions.assertTrue(game.makeMove(game.chessBoard[7][6], 5, 5));
    Assertions.assertTrue(game.makeMove(game.chessBoard[4][7], 6, 5));
    Assertions.assertTrue(game.makeMove(game.chessBoard[7][4], 6, 5));
    Assertions.assertTrue(game.makeMove(game.chessBoard[3][2], 6, 5));
    Assertions.assertTrue(game.currentPlayerLoses());
  }
}
