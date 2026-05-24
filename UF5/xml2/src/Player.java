public class Player {
  private String name;
  private String race;

  private ClassPlayer classPlayer;

  public Player(
      String name,
      String race,
      ClassPlayer classPlayer) {
    this.name = name;
    this.race = race;
    this.classPlayer = classPlayer;
  }

  public String getClassPlayer() {
    return this.classPlayer.getClassPj();
  }

  public String getName() {
    return this.name;
  }

  public String getRace() {
    return this.race;
  }

}
