package Game;

import java.util.ArrayList;
import Classes.Wizard;
import Spell;
import Spells;
import Game.FightProcesses;

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
    private EntityClass Class;
    private Spells currentSpells;

    public Player(int HP, int AR, Weapon weapon, int level, int roll, String weakType, EntityClass Class)
    {
        super(HP, AR, weapon, level, weakType, "isPlayer", true, Class);
        this.health = HP;
        this.armor = AR;
        this.weapon = weapon;
        this.level = level;
        this.roll = roll;
        this.weakType = weakType;
        this.Class = Class;
	if(Class.equals(Class.Wizard){this.currentSpells = Wizard.getSpells(level);}
	// add Wizard class with getSpells() method that takes an int and returns a Spell[] for that level (EX: level = 1, return Spell[] {Fireball};) // btw that isn't how it is done I am psuedocoding 
        playerList.add(this);
    }

    // Add player action and action menu
    public int playerAttack()
    {
        int playerDamage = weapon.getDamage();
	Entity target = chooseTarget(); // add chooseTarget() method that allows the player to choose an enemy from enemyList
	if(weapon.getWeaponName().equals("staff"))
	{
		doStaffAttacks();
		return target.getHealth();
	}
	else
	{
		int targetHealth = target.getHealth();
		if(weapon.getHasEffect()){weapon.effectProcess();}
		if(FightProcesses.attackRoll(roll) > target.getArmor())
		{
			targetHealth -= playerDamage;
			if(target.getWeakType.equals(weapon.getDamageType())
			{
				targetHealth -= playerDamage;
			}
		}
	}
	return targetHealth;
    }

    public void doStaffAttacks()
    {
	System.out.println(currentSpells.SPELLINV.toString());
	Scanner playerInput = new Scanner(System.in);
	String choice = playerInput.nextLine();
	if(SPELLINV.contains(choice)){currentSpells.chooseSpell(Spell.SPELLS.get(choice));}
    }

    public static ArrayList<Player> getPlayerList()
    {
        return playerList;
    }
}
