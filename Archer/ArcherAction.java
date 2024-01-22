package Archer;

import java.util.HashMap;

import Game.Action;

public class ArcherAction extends Action
{
    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;

    public static HashMap<String, Action> ACTIONS = new HashMap<String, Action>();

    public ArcherAction(){super();}

    public ArcherAction(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
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
