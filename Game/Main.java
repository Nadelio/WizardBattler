package Game;

import java.util.Scanner;

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

    private static int classChoice;

    public static EntityClass.Classes chooseClass()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please choose a class by entering the corresponding number!");
        printClasses();
        classChoice = in.nextInt();
        return EntityClass.Classes.getClass(classChoice);
    }

    public static void printClasses()
    {
        int classValue = 0;

        for(EntityClass.Classes c : EntityClass.Classes.values())
        {
            System.out.print(classValue);
            System.out.print(" : " + EntityClass.classList.get(classValue) + "\n");
            classValue++;
        }
    }

    public static void main(String[] args) 
    {
        gameStartAnim();
         
        // init weapons
        new Weapons();

        // set player's name and class
        System.out.println("Please type your name!");
        Scanner playerInput = new Scanner(System.in);
        String playerName = playerInput.nextLine();

        EntityClass.Classes playerClass = chooseClass();

        //Welcome the player
        System.out.println("Welcome " + playerName + "!\nYou have chosen the class " + EntityClass.classList.get(classChoice) + "!");

        // create the player
        player = new Player(10, 0, new BasicSword(), 1, 1, "NONE", playerClass, playerName);
        
        System.out.println("-----------------------------------------------------");

        new GenerateFight();
    }
}
