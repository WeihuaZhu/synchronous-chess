package com.whzhu.chess.models;

public class Rook extends ChessPiece {
  private int x;
  private int y;

  public Rook() {
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
