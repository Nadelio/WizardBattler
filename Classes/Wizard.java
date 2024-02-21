package Classes;

import java.util.HashMap;

import Weapons.*;
import Wizard.*;

public class Wizard extends Classes.Class
{
    
    private HashMap<Integer, Spells> LEVELACTIONS = new HashMap<Integer, Spells>();

    private static Spell[] levelOneSpells = {new Fireball(), new Recovery(), new Resistance()};
    private static Spell[] levelTwoSpells = {new Poison(), new Freeze()};

    public static Weapon starterWeapon = new BasicStaff();

    public Wizard()
    {
        LEVELACTIONS.put(1, new Spells(levelOneSpells));
        LEVELACTIONS.put(2, new Spells(levelTwoSpells));
    }
}
