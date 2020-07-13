package com.whzhu.chess.models;

public class Knight extends ChessPiece {

  public Knight(int row, int col, Color color) {
    super(row, col, color, "Knight");
    canBeBlocked = false;
  }

  @Override
  public boolean validMove(int destRow, int destCol, boolean captureMove) {
    return ((destRow == row - 1 || destRow == row + 1)
            && (destCol == col - 2 || destCol == col + 2))
        || ((destRow == row - 2 || destRow == row + 2)
            && (destCol == col - 1 || destCol == col - 1));
  }
}
