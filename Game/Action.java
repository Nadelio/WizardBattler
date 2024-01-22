package Game;

import java.util.HashMap;

public class Action
{
    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;

    public static HashMap<String, Action> ACTIONS = new HashMap<String, Action>();

    public Action(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;
        ACTIONS.put(name, this);
    }

    public boolean getHasEffect(){return hasEffect;}
    public int getActionDamage(){return damage;}
    public String getType(){return type;}
    public String getName(){return name;}
    public boolean getIsHarmful(){return isHarmful;}

    public void effectProcess(Entity target){}

    public String toString(){return getName();}
}
