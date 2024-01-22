package Classes;

import java.util.HashMap;

import Weapons.*;
import Wizard.*;

public class Wizard extends Classes.Class
{
    
    private static HashMap<Integer, Spells> LEVELSPELLS = new HashMap<Integer, Spells>();

    private static Spell[] levelOneSpells = {new Fireball(), new Recovery(), new Resistance()};
    private static Spell[] levelTwoSpells = {new Poison(), new Freeze()};

    public static Weapon starterWeapon = new BasicStaff();

    public Wizard()
    {
        LEVELSPELLS.put(1, new Spells(levelOneSpells));
        LEVELSPELLS.put(2, new Spells(levelTwoSpells));
    }
}
