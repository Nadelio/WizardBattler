package Paladin;

import java.util.HashMap;

import Game.Action;

public class PaladinAction extends Action
{
    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;
    public static HashMap<String, PaladinAction> PALADINACTIONS = new HashMap<String, PaladinAction>();
    
    public PaladinAction(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        super(hasEffect, damage, type, name, isHarmful);
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;
        PALADINACTIONS.put(name, this);
    }   

    public static HashMap<String, PaladinAction> getACTIONS(){return PALADINACTIONS;}
}
