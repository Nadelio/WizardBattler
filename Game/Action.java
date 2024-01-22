package Game;

import java.util.HashMap;

import Archer.ArcherAction;
import Fighter.FighterAction;
import Paladin.PaladinAction;
import Wizard.Spell;

public class Action
{
    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;
    public static HashMap<String, Action> ACTIONS = new HashMap<String, Action>();
    
    private static int databaseInitCount = 0;
    public static HashMap<String, Action> ActionDatabase = new HashMap<String, Action>();

    public Action(){}

    public Action(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;

        if(databaseInitCount == 0)
        {
            initActionDatabase();
            databaseInitCount++;
        }
    }

    private void initActionDatabase()
    {
        ActionDatabase.put("Fighter", new FighterAction());
        ActionDatabase.put("Wizard", new Spell());
        ActionDatabase.put("Archer", new ArcherAction());
        ActionDatabase.put("Paladin", new PaladinAction());
    }

    public boolean getHasEffect(){return hasEffect;}
    public int getActionDamage(){return damage;}
    public String getType(){return type;}
    public String getName(){return name;}
    public boolean getIsHarmful(){return isHarmful;}

    public HashMap<String, Action> getACTIONS(){return ACTIONS;}

    public void effectProcess(Entity target){}

    public String toString(){return getName();}
}
