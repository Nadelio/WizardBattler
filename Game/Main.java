package Game;

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

    public static Weapon getClassWeapon(EntityClass.Classes playerClass) //Todo: make HashMap that stores <EntityClasses.Class, Weapon> // like how Environment HashMaps are set up
    {//* iterate over HashMap that holds all the class weapons, checking if playerClass matches any class in the HashMap, then returning the associated HashMap value (aka the class weapon)
        if(playerClass.equals(EntityClass.Classes.Wizard)){return new BasicStaff();}
        else if(playerClass.equals(EntityClass.Classes.Fighter)){return new Fists();}
        else if(playerClass.equals(EntityClass.Classes.Archer)){return new BasicBow();}
        else if(playerClass.equals(EntityClass.Classes.Paladin)){return new BasicSword();}
        else
        {
            System.out.println("No weapon associated with chosen class, assigning Basic Sword to player.");
            return new BasicSword();
        }
    }

    public static void main(String[] args) 
    {
        gameStartAnim();
         
        // init weapons
        new Weapons();
        // init Environments
        new Environment();

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
