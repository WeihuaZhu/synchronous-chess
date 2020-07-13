package com.whzhu.chess.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessGame {
  private Player whitePlayer;
  private Player blackPlayer;
  private Player currentPlayer;
  public ChessPiece[][] chessBoard;

  public ChessGame(Player whitePlayer, Player blackPlayer) {
    this.whitePlayer = whitePlayer;
    this.blackPlayer = blackPlayer;
    initializeChessBoard();
    currentPlayer = this.whitePlayer;
  }

  private void switchPlayer() {
    if (currentPlayer == whitePlayer) {
      currentPlayer = blackPlayer;
    } else {
      currentPlayer = whitePlayer;
    }
  }

  public void initializeChessBoard() {
    chessBoard = new ChessPiece[8][8];
    for (int i = 0; i < 8; i++) {
      chessBoard[1][i] = new Pawn(1, i, Color.WHITE);
      chessBoard[6][i] = new Pawn(6, i, Color.BLACK);
    }
    chessBoard[0][0] = new Rook(0, 0, Color.WHITE);
    chessBoard[0][1] = new Knight(0, 0, Color.WHITE);
    chessBoard[0][2] = new Bishop(0, 0, Color.WHITE);
    chessBoard[0][3] = new Queen(0, 0, Color.WHITE);
    chessBoard[0][4] = new King(0, 0, Color.WHITE);
    chessBoard[0][5] = new Bishop(0, 0, Color.WHITE);
    chessBoard[0][6] = new Knight(0, 0, Color.WHITE);
    chessBoard[0][7] = new Rook(0, 0, Color.WHITE);

    chessBoard[7][0] = new Rook(0, 0, Color.BLACK);
    chessBoard[7][1] = new Knight(0, 0, Color.BLACK);
    chessBoard[7][2] = new Bishop(0, 0, Color.BLACK);
    chessBoard[7][3] = new Queen(0, 0, Color.BLACK);
    chessBoard[7][4] = new King(0, 0, Color.BLACK);
    chessBoard[7][5] = new Bishop(0, 0, Color.BLACK);
    chessBoard[7][6] = new Knight(0, 0, Color.BLACK);
    chessBoard[7][7] = new Rook(0, 0, Color.BLACK);
  }

  public boolean makeMove(ChessPiece piece, int destRow, int destCol) {
    int row = piece.getRow();
    int col = piece.getCol();
    // only can move piece with color that is assigned to current player
    if ((currentPlayer == whitePlayer && piece.getColor() == Color.BLACK)
        || (currentPlayer == blackPlayer && piece.getColor() == Color.WHITE)) {
      return false;
    }
    // must operate on an valid piece and destination is in bound
    if (piece == null || !inBound(destRow, destCol)) {
      return false;
    }
    // must move the piece away from its current coordinate
    if (destRow == piece.getRow() && destCol == piece.getCol()) {
      return false;
    }
    boolean isValidMove = false;
    if (chessBoard[destRow][destCol] != null
        && chessBoard[destRow][destCol].getColor() == piece.getColor()) {
      // cannot move the piece to another same color piece's coordinate
      return false;
    } else if (chessBoard[destRow][destCol] != null) {
      isValidMove = piece.validMove(destRow, destCol, true);
    } else {
      isValidMove = piece.validMove(destRow, destCol, false);
    }
    if (isValidMove) {
      // block check for this move
      if (piece.canBeBlocked && !blockCheck(row, col, destRow, destCol)) {
        return false;
      }
      // passed all move checks, the move is valid, make move
      // captured piece set dead
      if (chessBoard[destRow][destCol] != null) {
        chessBoard[destRow][destCol].setDead();
      }
      // move piece to dest position
      chessBoard[row][col] = null;
      chessBoard[destRow][destCol] = piece;
      piece.setPosition(destRow, destCol);
      // switch player
      switchPlayer();
    }
    return isValidMove;
  }

  private boolean blockCheck(int row, int col, int destRow, int destCol) {
    List<int[]> coordinatesCheckList = new ArrayList<int[]>();
    if (row == destRow) {
      if (col < destCol) {
        for (int i = col + 1; i < destCol; i++) {
          coordinatesCheckList.add(new int[] {row, i});
        }
      } else {
        for (int i = destCol + 1; i < col; i++) {
          coordinatesCheckList.add(new int[] {row, i});
        }
      }
    } else if (col == destCol) {
      if (row < destRow) {
        for (int i = row + 1; i < destRow; i++) {
          coordinatesCheckList.add(new int[] {i, col});
        }
      } else {
        for (int i = destRow + 1; i < row; i++) {
          coordinatesCheckList.add(new int[] {i, col});
        }
      }
    } else {
      if (row < destRow) {
        if (col < destCol) {
          for (int i = 1; i < destRow - row; i++) {
            coordinatesCheckList.add(new int[] {row + i, col + i});
          }
        } else {
          for (int i = 1; i < destRow - row; i++) {
            coordinatesCheckList.add(new int[] {row + i, col - i});
          }
        }
      } else {
        if (col < destCol) {
          for (int i = 1; i < destRow - row; i++) {
            coordinatesCheckList.add(new int[] {row - i, col + i});
          }
        } else {
          for (int i = 1; i < destRow - row; i++) {
            coordinatesCheckList.add(new int[] {row - i, col - i});
          }
        }
      }
    }
    if (coordinatesCheckList.isEmpty()) {
      return true;
    } else {
      for (int[] coordinate : coordinatesCheckList) {
        if (chessBoard[coordinate[0]][coordinate[1]] != null) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean inBound(int row, int col) {
    return row >= 0 && row < 8 && col >= 0 && col < 8;
  }

  public static void main(String[] args) {
    Player p1 = new Player(1, "p1");
    Player p2 = new Player(2, "p2");
    ChessGame g = new ChessGame(p1, p2);
    for (int i = 7; i >= 0; i--) {
      System.out.println(Arrays.toString(g.chessBoard[i]));
    }
    System.out.println("\n\n");

    System.out.println(g.makeMove(g.chessBoard[1][0], 3, 0));
    for (int i = 7; i >= 0; i--) {
      System.out.println(Arrays.toString(g.chessBoard[i]));
    }
    System.out.println("\n\n");

    System.out.println(g.makeMove(g.chessBoard[6][0], 4, 0));
    for (int i = 7; i >= 0; i--) {
      System.out.println(Arrays.toString(g.chessBoard[i]));
    }
    System.out.println("\n\n");
  }
}
