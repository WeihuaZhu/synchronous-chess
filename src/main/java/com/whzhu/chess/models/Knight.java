package com.whzhu.chess.models;

public class Knight extends ChessPiece {
  private int x;
  private int y;

  public Knight() {
    super();
  }

  @Override
  public boolean move(int x, int y, MoveStrategy mv) {
    return false;
  }

  @Override
  public boolean validMove() {
    return false;
  }
}
