public class Game {
  private int idGames;
  private String house;
  private byte houseResult;
  private String visitor;
  private byte visitorResult;

  public Game(int idGames, String house, byte houseResult, String visitor, byte visitorResult) {
    this.idGames = idGames;
    this.house = house;
    this.houseResult = houseResult;
    this.visitor = visitor;
    this.visitorResult = visitorResult;
  }

  public String getHouse() {
    return this.house;
  }

  public byte getHouseR() {
    return this.houseResult;
  }

  public String getVisitor() {
    return this.visitor;
  }

  public byte getVisitorR() {
    return this.visitorResult;
  }

  public int getIdGames() {
    return this.idGames;
  }

}