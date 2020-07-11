package com.whzhu.chess.models;

public abstract class ChessPiece implements ChessPieceRule {
  private boolean alive;

  public abstract boolean move(int x, int y, MoveStrategy mv);

  public ChessPiece() {
    this.alive = true;
  }

  public void setDead() {
    this.alive = false;
  }
}
