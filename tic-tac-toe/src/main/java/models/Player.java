package models;

public class Player {
  private final String id;
  private String name;
  private char sign;

  public Player(String name, char sign, String id) {
    this.name = name;
    this.sign = sign;
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setSign(char sign) {
    this.sign = sign;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public char getSign() {
    return sign;
  }
}
