package Classes;

import java.util.HashMap;
import Fighter.*;

public class Fighter extends Classes.Class
{
    private static HashMap<Integer, FighterActions> LEVELACTIONS = new HashMap<Integer, FighterActions>();

    private static FighterAction[] levelOneActions = {new TriplePunch(), new Dodge(), new StrongPunch()};
    private static FighterAction[] levelTwoActions = {new Toughen(), new FirePunch()};

    public Fighter()
    {
        LEVELACTIONS.put(1, new FighterActions(levelOneActions));
        LEVELACTIONS.put(2, new FighterActions(levelTwoActions));
    }
}