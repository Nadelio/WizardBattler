package Archer;

import java.util.HashMap;

import Classes.Archer;
import Game.Action;
import Game.Entity;

public class ArcherAction extends Action
{
    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;

    public static HashMap<String, ArcherAction> ARCHERACTIONS = new HashMap<String, ArcherAction>();

    public ArcherAction(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        super(hasEffect, damage, type, name, isHarmful);
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;
        ARCHERACTIONS.put(name, this);
    }

    public static HashMap<String, ArcherAction> getACTIONS(){return ARCHERACTIONS;}
}
