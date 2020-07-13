package com.whzhu.chess.models;

public class King extends ChessPiece {
  public King(int row, int col, Color color) {
    super(row, col, color, "King");
    canBeBlocked = false;
  }

  @Override
  public boolean validMove(int destRow, int destCol, boolean captureMove) {
    return destRow - row <= 1 && row - destRow <= 1 && destCol - col <= 1 && col - destCol <= 1;
  }
}
