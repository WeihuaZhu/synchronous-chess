package com.whzhu.chess.models;

public class Pawn extends ChessPiece {
  private boolean atInitPosition;

  public Pawn(int x, int y, Color color) {
    super(x, y, color);
    this.atInitPosition = true;
  }

  @Override
  public boolean move(int destX, int destY) {
    return false;
  }

  @Override
  public boolean validMove(int destX, int destY) {
    if (atInitPosition) {
      return destX == x && destY - y > 0 && destY - y <= 2;
    } else {
      return destX == x && destY - y == 1;
    }
  }
}
