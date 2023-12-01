package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Classes.Wizard;
import Wizard.Spell;
import Wizard.Spells;

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

    public Player(int HP, int AR, Weapon weapon, int level, int roll, String weakType, EntityClass.Classes Class, String entityName)
    {
        super(HP, AR, weapon, level, weakType, "isPlayer", true, Class, entityName);
        this.health = HP;
        this.armor = AR;
        this.weapon = weapon;
        this.level = level;
        this.roll = roll;
        this.weakType = weakType;
        this.Class = Class;
        this.entityName = entityName;
	    if(Class.equals(EntityClass.Classes.Wizard)){this.currentSpells = Wizard.getSpells(level);}

        playerList.add(this);
    }

    // Add player action and action menu
    
    public int playerAttack()
    {
        int playerDamage = weapon.getDamage();
	    Entity target = chooseTarget();
        while(target == null)
        {
            System.out.println("Error, target does not exist");
            target = chooseTarget();
        }

	    if(weapon.getWeaponName().equals("staff"))
	    {
	    	doStaffAttacks();
	    	return target.getHealth();
	    }
	    else
	    {
	    	int targetHealth = target.getHealth();
		    if(weapon.getHasEffect()){weapon.effectProcess(target);}
		    if(FightProcesses.attackRoll(roll) > target.getArmor())
		    {
		    	targetHealth -= playerDamage;
		    	if(target.getWeakType().equals(weapon.getDamageType()))
		    	{
		    		targetHealth -= playerDamage;
		    	}
		    }
            return targetHealth;
	    }
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
    }

    public void doStaffAttacks()
    {
	    System.out.println(currentSpells.getSpellInventory().toString());
	    try (Scanner playerInput = new Scanner(System.in))
        {
            String choice = playerInput.nextLine();
            if(Arrays.asList(currentSpells.getSpellInventory()).contains(Spell.SPELLS.get(choice))){currentSpells.chooseSpell(Spell.SPELLS.get(choice));}
        }
    }

    public static ArrayList<Player> getPlayerList()
    {
        return playerList;
    }
}
