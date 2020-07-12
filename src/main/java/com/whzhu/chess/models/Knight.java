package com.whzhu.chess.models;

public class Knight extends ChessPiece {

  public Knight(int x, int y, Color color) {
    super(x, y, color);
  }

  @Override
  public boolean move(int destX, int destY) {
    return false;
  }

  @Override
  public boolean validMove(int destX, int destY) {
    return false;
  }
}
