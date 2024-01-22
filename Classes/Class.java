package Classes;

import java.util.HashMap;

import Game.Actions;

public class Class
{
    private static HashMap<Integer, Actions> LEVELACTIONS = new HashMap<Integer, Actions>();
    public static Actions getActions(int level){return LEVELACTIONS.get(level);}
}
