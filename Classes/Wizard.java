package Classes;

import java.util.HashMap;

import Wizard.*;

public class Wizard
{
    
    private static HashMap<Integer, Spells> LEVELSPELLS = new HashMap<Integer, Spells>();

    private static Spell[] levelOneSpells = {new Fireball(), new Recovery(), new Resistance()};
    private static Spell[] levelTwoSpells = {new Poison(), new Freeze()};

    public Wizard()
    {
        LEVELSPELLS.put(1, new Spells(levelOneSpells));
        LEVELSPELLS.put(2, new Spells(levelTwoSpells));
    }
    
    public static Spells getSpells(int level){return LEVELSPELLS.get(level);}
}
