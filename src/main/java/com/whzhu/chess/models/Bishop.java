package com.whzhu.chess.models;

public class Bishop extends ChessPiece {

  public Bishop(int row, int col, Color color) {
    super(row, col, color, "Bishop");
    canBeBlocked = true;
  }

  @Override
  public boolean validMove(int destRow, int destCol, boolean captureMove) {
    return destRow - row == destCol - col || destRow - row == col - destCol;
  }
}
