package com.whzhu.chess.models;

public class Bishop extends ChessPiece {

  public Bishop(int x, int y, Color color) {
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
