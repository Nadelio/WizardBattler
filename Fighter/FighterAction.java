package Fighter;

import java.util.HashMap;

import Game.Action;

public class FighterAction extends Action
{
    private boolean hasEffect;
    private int damage;
    private String type;
    private String name;
    private boolean isHarmful;

    public static HashMap<String, FighterAction> FIGHTERACTIONS = new HashMap<String, FighterAction>();

    public FighterAction(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
    {
        super(hasEffect, damage, type, name, isHarmful);
        this.hasEffect = hasEffect;
        this.damage = damage;
        this.type = type;
        this.name = name;
        this.isHarmful = isHarmful;
        FIGHTERACTIONS.put(name, this);
    }

    public static HashMap<String, FighterAction> getACTIONS(){return FIGHTERACTIONS;}
}
