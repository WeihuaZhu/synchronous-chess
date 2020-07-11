package com.whzhu.chess.models;

public class Pawn extends ChessPiece {
  private int x;
  private int y;

  public Pawn() {
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
