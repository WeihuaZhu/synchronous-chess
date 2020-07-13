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
  public void testOpeningMoves() throws Exception {
    Assertions.assertTrue(game.makeMove(game.chessBoard[1][3], 3, 3)); // white queen's pawn opening
    Assertions.assertTrue(game.makeMove(game.chessBoard[6][4], 4, 4)); // black king's pawn opening
    Assertions.assertTrue(
        game.makeMove(game.chessBoard[3][3], 4, 4)); // white pawn capture black pawn
  }

  @Test
  public void testIncorrectStarterPlayer() throws Exception {
    Assertions.assertFalse(game.makeMove(game.chessBoard[6][1], 5, 1));
  }
}
