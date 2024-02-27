package Wizard;

import java.util.HashMap;

import Game.Action;
import Game.Environment;

public class Spell extends Action
{

    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;
    
    public Spell(){super();}

    public Spell(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        super(hasEffect, damage, type, name, isHarmful);
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;
        Environment.spellDatabase.put(name, this);
    }
}
