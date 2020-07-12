package com.whzhu.chess.models;

public class Rook extends ChessPiece {

  public Rook(int x, int y, Color color) {
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
