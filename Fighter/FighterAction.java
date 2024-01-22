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

    public static HashMap<String, Action> ACTIONS = new HashMap<String, Action>();

    public FighterAction(){super();}

    public FighterAction(boolean hasEffect, int damage, String type, String name, boolean isHarmful)
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
