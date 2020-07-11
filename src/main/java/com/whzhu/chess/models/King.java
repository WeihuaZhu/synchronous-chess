package com.whzhu.chess.models;

public class King extends ChessPiece {
  private int x;
  private int y;

  public King() {
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
