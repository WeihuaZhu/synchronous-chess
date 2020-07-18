package com.whzhu.chess.models;

public abstract class ChessPiece implements ChessPieceRule {
  protected int row;
  protected int col;
  protected Color color;
  protected boolean alive;
  protected String role;
  protected boolean canBeBlocked;
  protected boolean atInitPosition;

  public ChessPiece(int row, int col, Color color, String role) {
    this.alive = true;
    this.atInitPosition = true;
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

  public boolean isAlive() {
    return alive;
  }

  protected void setPosition(int row, int col) {
    this.row = row;
    this.col = col;
    this.atInitPosition = false; // not atInitPosition once moved
  }

  @Override
  public String toString() {
    return String.format("%s-%s", role, color.toString());
  }
}
