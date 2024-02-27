package Paladin;

import java.util.HashMap;

import Game.Action;
import Game.Environment;

public class PaladinAction extends Action
{
    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;
    
    public PaladinAction(){super();}

    public PaladinAction(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        super(hasEffect, damage, type, name, isHarmful);
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;
        Environment.paladinActionDatabase.put(name, this);
    }
}
