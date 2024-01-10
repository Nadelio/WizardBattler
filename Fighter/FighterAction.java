package Fighter;

import java.util.HashMap;
import Game.Entity;

public class FighterAction
{
    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;

    public static HashMap<String, FighterAction> FIGHTERACTIONS = new HashMap<String, FighterAction>();

    public FighterAction(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;
        FIGHTERACTIONS.put(name, this);
    }

    public boolean getHasEffect(){return hasEffect;}
    public int getActionDamage(){return damage;}
    public String getType(){return type;}
    public String getName(){return name;}
    public boolean getIsHarmful(){return isHarmful;}

    public void effectProcess(Entity target){}

    public String toString(){return getName();}

}
