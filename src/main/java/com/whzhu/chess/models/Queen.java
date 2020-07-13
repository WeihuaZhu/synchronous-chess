package com.whzhu.chess.models;

public class Queen extends ChessPiece {

  public Queen(int row, int col, Color color) {
    super(row, col, color, "Queen");
    canBeBlocked = true;
  }

  @Override
  public boolean validMove(int destRow, int destCol, boolean captureMove) {
    return destRow == row || destCol == col || destRow - row == destCol - col || destRow - row == col - destCol;
  }
}
