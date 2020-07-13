package com.whzhu.chess.models;

public class Rook extends ChessPiece {

  public Rook(int row, int col, Color color) {
    super(row, col, color, "Rook");
    canBeBlocked = true;
  }

  @Override
  public boolean validMove(int destRow, int destCol, boolean captureMove) {
    return destRow == row || destCol == col;
  }
}
