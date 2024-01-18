package Game;

import java.io.IOError;
import java.io.IOException;

import Classes.EntityClass;
import Weapons.BasicSword;
import Weapons.Weapons;

public class Main
{
    private static Player player;

    public static Player getPlayer(){return player;}

    public static void gameStartAnim()
    {
        String gameConsoleTitle = "GAME START!";
        for(int i = 0; i < gameConsoleTitle.length(); i++)
        {
            char c = gameConsoleTitle.charAt(i);
            System.out.print(c);
            try {Thread.sleep(150);}catch(InterruptedException e){}
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        gameStartAnim();
        new Weapons();
        player = new Player(10, 0, new BasicSword(), 1, 1, "NONE", EntityClass.Classes.Fighter, "test_player");
        new GenerateFight();
    }
}
