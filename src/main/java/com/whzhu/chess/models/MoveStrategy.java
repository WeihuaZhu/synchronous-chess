package com.whzhu.chess.models;

public class MoveStrategy {
  private int direction;
  private int steps;

  public MoveStrategy(int direction, int steps) {
    this.direction = direction;
    this.steps = steps;
  }
}
