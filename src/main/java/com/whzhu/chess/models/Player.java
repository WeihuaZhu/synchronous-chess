package com.whzhu.chess.models;

public class Player {

  private final long id;
  private final String userName;

  public Player(long id, String userName) {
    this.id = id;
    this.userName = userName;
  }

  public long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }
}
