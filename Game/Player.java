package Game;

import java.util.ArrayList;

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
        playerList.add(this);
    }

    // Add player action
    public int playerAttack()
    {
        int playerDamage = weapon.getDamage();
	Entity target = chooseTarget();
	if(weapon.getWeaponName().equals("staff"))
	{
		doStaffAttacks();
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

    public static ArrayList<Player> getPlayerList()
    {
        return playerList;
    }
}
