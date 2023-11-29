import Game.Enemy; // gets Enemy data type

public class Spell
{
    private boolean hasEffect;
    private int damage;
    private String type;
    
    public Spell(boolean hasEffect, int damage, String type)
    {
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
    }

    public boolean getHasEffect(){return hasEffect;}
    public int getSpellDamage(){return damage;}
    public String getType(){return type;}

    public void effectProcess(Enemy currentEnemy){}
}
