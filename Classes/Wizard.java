package Classes;

import java.util.HashMap;

import Wizard.*;

public class Wizard
{
    
    private static final HashMap<Integer, Spells> LEVELSPELLS = new HashMap<Integer, Spells>();

    private Spell[] levelOneSpells = {new Fireball(), new Recovery(), new Resistance()};

    public Wizard()
    {
        LEVELSPELLS.put(1, new Spells(levelOneSpells));
        LEVELSPELLS.put(2, null); // poison, freeze
    }
    
    public static Spells getSpells(int level){return LEVELSPELLS.get(level);}
}
