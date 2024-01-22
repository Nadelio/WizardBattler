package Classes;

import java.util.HashMap;

import Paladin.*;


public class Paladin extends Classes.Class
{
    private static HashMap<Integer, PaladinActions> LEVELACTIONS = new HashMap<Integer, PaladinActions>();

    private static PaladinAction[] levelOneActions = {new HealingPrayer(), new DownwardSlash(), new ShieldBlock()};
    private static PaladinAction[] levelTwoActions = {new Blessing(), new Smite()};

    public Paladin()
    {
        LEVELACTIONS.put(1, new PaladinActions(levelOneActions));
        LEVELACTIONS.put(2, new PaladinActions(levelTwoActions));
    }
}
