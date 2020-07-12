package com.whzhu.chess.models;

public abstract class ChessPiece implements ChessPieceRule {
  protected int x;
  protected int y;
  protected Color color;
  protected boolean alive;

  public abstract boolean move(int destX, int destY);

  public ChessPiece(int x, int y, Color color) {
    this.alive = true;
    this.x = x;
    this.y = y;
  }

  public void setDead() {
    this.alive = false;
  }
}
