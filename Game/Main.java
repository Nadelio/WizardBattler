package Game;

import java.util.HashMap;
import java.util.Scanner;

import Classes.*;
import Weapons.*;

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

    public static HashMap<EntityClass.Classes, Weapon> classWeapons = new HashMap<EntityClass.Classes, Weapon>();

    public static void initClassWeapons()
    {
        classWeapons.put(EntityClass.Classes.Fighter, new Fists());
        classWeapons.put(EntityClass.Classes.Wizard, new BasicStaff());
        classWeapons.put(EntityClass.Classes.Archer, new BasicBow());
        classWeapons.put(EntityClass.Classes.Paladin, new BasicSword());
    }

    public static Weapon getClassWeapon(EntityClass.Classes playerClass)
    {
        try
        {
            return classWeapons.get(playerClass);
        }
        catch(NullPointerException e)
        {
            System.out.println("Class does not exist or have associated weapon, please add an appropriate entry to classWeapons.");
            return null;
        }
    }

    public static void main(String[] args) 
    {
        gameStartAnim();
         
        // init weapons
        new Weapons();
        // init Environments
        new Environment();
        // init classWeapons
        initClassWeapons();

        // set player's name and class
        System.out.println("Please type your name!");
        Scanner playerInput = new Scanner(System.in);
        String playerName = playerInput.nextLine();
        EntityClass.Classes playerClass = chooseClass();
        Weapon classWeapon = getClassWeapon(playerClass);

        //Welcome the player
        System.out.println("Welcome " + playerName + "!\nYou have chosen the class " + EntityClass.classList.get(classChoice) + "!");

        // create the player
        player = new Player(10, 0, classWeapon, 1, 20, "NONE", playerClass, playerName, "Town");
        
        System.out.println("-----------------------------------------------------");

        new GenerateFight(); //! FOR TESTING ONLY REMOVE BEFORE FINAL VERSION !//
    }
}
