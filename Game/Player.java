package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Archer.ArcherActions;
import Classes.EntityClass;
import Classes.Fighter;
import Classes.Wizard;
import Classes.Archer;
import Events.*;
import Fighter.FighterActions;
import Wizard.*;

public class Player extends Entity
{
    private static ArrayList<Player> playerList;

    private int health;
	private int armor;
	private Weapon weapon;
	private int roll;
    private int level;
	private String weakType;
	private String type;
    private EntityClass.Classes Class;
    private String entityName;
    private Spells currentSpells;
    private FighterActions currentFighterActions;
    private ArcherActions currentArcherActions;
    private int turnDamage;

    private boolean frozen = false;

    public Player(int HP, int AR, Weapon weapon, int level, int roll, String weakType, EntityClass.Classes Class, String entityName)
    {
        super(HP, AR, weapon, level, weakType, "isPlayer", true, Class, entityName);
        this.health = HP;
        this.armor = AR;
        this.weapon = weapon;
        this.level = level;
        this.roll = roll;
        this.weakType = weakType;
        this.type = "isPlayer";
        this.Class = Class;
        this.entityName = entityName;
	    if(Class.equals(EntityClass.Classes.Wizard)){this.currentSpells = Wizard.getSpells(level);}
        else if(Class.equals(EntityClass.Classes.Fighter)){this.currentFighterActions = Fighter.getActions(level);}
        else if(Class.equals(EntityClass.Classes.Archer)){this.currentArcherActions = Archer.getActions(level);}

        playerList.add(this);
    }

    // Add player action and action menu
    public void playerAction()
    {
        // do stuff
        FightProcesses.nextTurn();
    }
    
    public void playerAttack()
    {
        int playerDamage = weapon.getDamage();
	    Entity target = chooseTarget();
        int targetHealth = target.getHealth();
        int staffDamage = 0;

        while(target == null)
        {
            System.out.println("Error, target does not exist");
            target = chooseTarget();
        }
        if(frozen == false)
        {
            if(!target.getDodged())
            {
	            if(weapon.getWeaponType().equals("staff"))
	            {
                    this.turnDamage += staffDamage;
                    staffDamage = doStaffAttacks();
	        	    target.setHealth(target.getHealth() - staffDamage);
	            }
	            else
	            {
		            if(weapon.getHasEffect()){weapon.effectProcess(target);}
		            if(FightProcesses.attackRoll(roll) > target.getArmor())
		            {
                        this.turnDamage += playerDamage;
		        	    targetHealth -= playerDamage;
		        	    if(target.getWeakType().equals(weapon.getDamageType()))
		        	    {
                            this.turnDamage += playerDamage;
		        		    targetHealth -= playerDamage;
		        	    }
		            }
                    target.setHealth(targetHealth);
	            }
            }
        }
        FightProcesses.nextTurn();
    }

    public Enemy chooseTarget()
    {
        System.out.println(Enemy.getEnemyList().toString());
        try (Scanner playerInput = new Scanner(System.in))
        {
            String input = playerInput.nextLine();
            for(Enemy enemy : Enemy.getEnemyList()){if(enemy.getName().equals(input)){return enemy;}}
            return null;
        }
        catch(Exception e)
        {
            System.out.println(e.getStackTrace());
            return chooseTarget();
        }
    }

    public int doStaffAttacks()
    {
	    System.out.println(currentSpells.getSpellInventory().toString());
	    try (Scanner playerInput = new Scanner(System.in))
        {
            String choice = playerInput.nextLine();
            if(Arrays.asList(currentSpells.getSpellInventory()).contains(Spell.SPELLS.get(choice))){return currentSpells.chooseSpell(Spell.SPELLS.get(choice));}
            return doStaffAttacks();
        }
    }

    public static ArrayList<Player> getPlayerList()
    {
        return playerList;
    }

    @Override
    public String toString(){return entityName;}
}
