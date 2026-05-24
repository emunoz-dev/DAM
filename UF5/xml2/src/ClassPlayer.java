public abstract class ClassPlayer {
  private String classPj;
  private CombatStats stats;

  public ClassPlayer(String classPj, CombatStats stats) {
    this.classPj = classPj;
    this.stats = stats;
  }

  public String getClassPj() {
    return this.classPj;
  }

  public CombatStats getStats() {
    return this.stats;
  }

}
