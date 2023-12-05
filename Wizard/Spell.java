package Wizard;

import java.util.HashMap;
import Game.Entity;

public class Spell
{

    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;
    public static final HashMap<String, Spell> SPELLS = new HashMap<String, Spell>();
    
    public Spell(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;
        SPELLS.put(name, this);
    }


    public boolean getHasEffect(){return hasEffect;}
    public int getSpellDamage(){return damage;}
    public String getType(){return type;}
    public String getName(){return name;}
    public boolean getIsHarmful(){return isHarmful;}
    
    public void effectProcess(Entity target){}

    public String toString(){return getName();}
}
