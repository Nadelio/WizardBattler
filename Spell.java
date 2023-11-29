import Game.Enemy; // gets Enemy data type

public class Spell
{
    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    
    public Spell(boolean hasEffect, int damage, String type, String name)
    {
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
    }

    public boolean getHasEffect(){return hasEffect;}
    public int getSpellDamage(){return damage;}
    public String getType(){return type;}
    public String getName(){return name;}

    public void effectProcess(Enemy currentEnemy){}
}
