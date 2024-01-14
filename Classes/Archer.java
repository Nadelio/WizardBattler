package Classes;

import java.util.HashMap;

import Archer.ArcherAction;
import Archer.ArcherActions;

public class Archer
{
    private static HashMap<Integer, ArcherActions> LEVELACTIONS = new HashMap<Integer, ArcherActions>();

    private static ArcherAction[] levelOneActions = {new FireArrow(), new SmokeArrow(), new StormArrow()};
    private static ArcherAction[] levelTwoActions = {new ThunderArrow(), new BusterArrow()};

    public Archer()
    {
        LEVELACTIONS.put(1, new ArcherActions(levelOneActions));
        LEVELACTIONS.put(2, new ArcherActions(levelTwoActions));
    }

    public static ArcherActions getActions(int level){return LEVELACTIONS.get(level);}
}
