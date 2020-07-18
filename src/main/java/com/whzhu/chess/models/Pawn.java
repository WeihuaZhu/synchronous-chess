package com.whzhu.chess.models;

public class Pawn extends ChessPiece {

  public Pawn(int row, int col, Color color) {
    super(row, col, color, "Pawn");
    canBeBlocked = true;
  }

  // TODO refactor move logic using strategy design pattern
  @Override
  public boolean validMove(int destRow, int destCol, boolean captureMove) {
    boolean isValidMove = false;
    if (color == Color.WHITE) {
      isValidMove = validMoveForWhite(destRow, destCol, captureMove);
    } else if (color == Color.BLACK) {
      isValidMove = validMoveForBlack(destRow, destCol, captureMove);
    } else {
      // TODO throw/handle exception here, color not set
    }
    return isValidMove;
  }

  private boolean validMoveForWhite(int destRow, int destCol, boolean captureMove) {
    if (captureMove) {
      return destRow == row + 1 && (destCol == col - 1) || (destCol == col + 1);
    } else if (atInitPosition) {
      return (destRow == row + 1 || destRow == row + 2) && destCol == col;
    } else {
      return destRow == row + 1 && destCol == col;
    }
  }

  private boolean validMoveForBlack(int destRow, int destCol, boolean captureMove) {
    if (captureMove) {
      return destRow == row - 1 && (destCol == col - 1) || (destCol == col + 1);
    } else if (atInitPosition) {
      return (destRow == row - 1 || destRow == row - 2) && destCol == col;
    } else {
      return destRow == row - 1 && destCol == col;
    }
  }
}
