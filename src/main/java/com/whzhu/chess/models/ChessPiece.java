package com.whzhu.chess.models;

public abstract class ChessPiece implements ChessPieceRule {
  protected int row;
  protected int col;
  protected Color color;
  protected boolean alive;
  protected String role;
  protected boolean canBeBlocked;

  public ChessPiece(int row, int col, Color color, String role) {
    this.alive = true;
    this.row = row;
    this.col = col;
    this.role = role;
    this.color = color;
  }

  public void setDead() {
    this.alive = false;
  }

  public Color getColor() {
    return color;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  protected void setPosition(int row, int col) {
    this.row = row;
    this.col = col;
  }

  @Override
  public String toString() {
    return String.format("%s-%s", role, color.toString());
  }
}
