package Game;

import Game.FightProcesses; // gives attackRoll() and getTarget()
import java.util.*; // gives various utilites

public class Enemy extends Entity
{
    private int enemyHealth;
	private int enemyArmor;
	private Weapon enemyWeapon;
	private int enemyRoll;
    private int enemyLevel;
	private String weakType;
	private String type;
    private EntityClass Class;

    private static ArrayList<Enemy> enemyList;

	private Player target;

    public Enemy(int HP, int AR, Weapon weapon, int level, int roll, String weakType, String type, EntityClass Class)
    {
        this.enemyHealth = HP;
		this.enemyArmor = AR;
		this.enemyWeapon = weapon;
        this.enemyLevel = level;
        this.enemyRoll = roll;
		this.weakType = weakType;
		this.type = type;
        this.Class = Class;
        enemyList.add(this);
    }

    public int enemyAttack()
    {
        target = FightProcesses.getTarget();
        int targetHP = target.getHealth();
        if(FightProcesses.attackRoll(enemyRoll) > target.getArmor())
        {
            targetHP -= enemyWeapon.getDamage();
        }

        return targetHP;
    }

    public static ArrayList<Enemy> getEnemyList()
    {
        return enemyList;
    }
}
