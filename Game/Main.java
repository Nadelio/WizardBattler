package Game;

import Classes.EntityClass;
import Weapons.BasicSword;

public class Main
{
    private static Player player;

    public static Player getPlayer(){return player;}

    public static void main(String[] args) 
    {
        player = new Player(10, 1, new BasicSword(), 1, 1, "NONE", EntityClass.Classes.Fighter, "test_player");
    }
}
