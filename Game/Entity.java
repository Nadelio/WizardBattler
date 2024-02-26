package Game;

import java.util.Random;
import java.util.Scanner;

import Classes.EntityClass;
import Fighter.FighterActions;
import Weapons.Weapon;
import Wizard.Spells;

public class Entity
{
    private int HP;
    private int AR;
    private Weapon weapon;
    private int level;
    private int roll;
    private String weakType;
    private String strongType;
    private boolean entityType;
    private EntityClass.Classes Class;
    private Entity target;
    private String entityName;
    private Spells currentSpells;
    private FighterActions currentActions;
    private int turnDamage;
    private boolean frozen = false;
    private boolean dodged = false;
    private boolean dead = false;
    private String currentEnvironment;
    private boolean firstRun = true;
    
    public Entity(int HP, int AR, Weapon weapon, int level, String weakType, String strongType, boolean entityType, EntityClass.Classes Class, String entityName, String currentEnvironment)
    {
        this.HP = HP;
        this.AR = AR;
        this.weapon = weapon;
        this.level = level;
        Random random = new Random();
        this.roll = random.nextInt(level, level + 4);
        this.weakType = weakType;
        this.strongType = strongType;
        this.entityType = entityType;
        this.Class = Class;
        this.entityName = entityName;
        this.currentEnvironment = currentEnvironment;

        Environment.entityList.add(this);
    }

    public void playTurn()
    {
        if(entityType)
        {
            System.out.println(FightProcesses.getCurrentPlayer() + "'s turn!");
            System.out.println("Type 'action' to open the action menu, or do 'attack' to do your attack!");
            System.out.print("Input: ");
            if(firstRun){Main.playerScanner.nextLine(); firstRun = false;}
            String input = Main.playerScanner.nextLine();
            if(input.strip().toLowerCase().equals("action"))
            {
                FightProcesses.getCurrentPlayer().playerAction();
            }
            else if(input.strip().toLowerCase().equals("attack"))
            {
                FightProcesses.getCurrentPlayer().playerAttack();
            }
            else
            {
                playTurn();
            }
        }
        else
        {
            System.out.println(FightProcesses.getCurrentEnemy() + "'s turn!");
            FightProcesses.getCurrentEnemy().enemyTurn();
        }
    }

    
    public int getHealth(){return HP;}
    public int getArmor(){return AR;}
    public Weapon getWeapon(){return weapon;}
    public int getLevel(){return level;}
    public int getRoll(){return roll;}
    public String getWeakType(){return weakType;}
    public String getStrongType(){return strongType;}
    public boolean getEntityType(){return entityType;}
    public EntityClass.Classes getEntityClass(){return Class;}
    public Entity getCurrentTarget(){if(target == null){return null;} return target;}
    public String getName(){return entityName;}
    public int getTurnDamage(){return turnDamage;}
    public Spells getCurrentSpells(){return currentSpells;}
    public FighterActions getCurrentActions(){return currentActions;}
    public boolean getDodged(){return dodged;}
    public String getCurrentEnvironment(){return currentEnvironment;}
    public boolean getDead(){return dead;}

    public void setHealth(int newHealth){this.HP = newHealth;}
    public void setArmor(int newArmor){this.AR = newArmor;}
    public void setFrozen(){this.frozen = true;}
    public void setUnfrozen(){this.frozen = false;}
    public void setDodged(){this.dodged = !dodged;}
    public void setDead(){this.dead = true;}
    public void setFirstRun(){this.firstRun = true;}
}
