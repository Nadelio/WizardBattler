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
    public static HashMap<String, Action> ACTIONS = new HashMap<String, Action>();
    
    public PaladinAction(){super();}

    public PaladinAction(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        super(hasEffect, damage, type, name, isHarmful);
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;
        this.ACTIONS.put(name, this);
    }
}
