public class CombatStats{
  private int health;
  private int armor;
  private int baseAttack;
  private int baseAvoidAttacks;
  private int baseThreat;


  public CombatStats(
      int health,
      int armor,
      int baseAttack,
      int baseAvoidAttacks,
      int baseThreat
  ) {
    
    this.health = health;
    this.armor = armor;
    this.baseAttack = baseAttack;
    this.baseAvoidAttacks = baseAvoidAttacks;
    this.baseThreat = baseThreat;
  }

  public int getHealth() {
    return this.health;
  }

  public int getArmor() {
    return this.armor;
  }

  public int getBaseAttack() {
    return this.baseAttack;
  }

  public int getBaseAvoidAttacks() {
    return this.baseAvoidAttacks;
  }

  public int getBaseThreat() {
    return this.baseThreat;
  }
  
}
