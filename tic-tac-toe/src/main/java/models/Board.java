package models;

public abstract class Board {

  private String id;
  public Board(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
