public class Warrior extends ClassPlayer {
  
  public final static String CLASS_PJ = "Warrior";

  private int statShield;
  private int probabilityBlock;
  //private CombatStats stats;
  
  private boolean buffBlock;


  public Warrior(CombatStats stats, int statShield, int probabilityBlock) {
    super(CLASS_PJ, stats);
    this.statShield = statShield;
    this.probabilityBlock = probabilityBlock;
    this.buffBlock = false;
  }

  public int blockAtack() {
    return -1;
  }
  
  public int plusThreat() {
    return -1;
  }

  public int activateBuffBlock() {
    return -1;
  }

}
