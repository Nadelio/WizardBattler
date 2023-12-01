package Game;

import java.util.*; // gives various utilites

public class Enemy extends Entity
{
    private int health;
    private int armor;
    private Weapon weapon;
    private int roll;
    private int level;
    private String weakType;
    private String type;
    private EntityClass.Classes Class;

    private static ArrayList<Enemy> enemyList;

    private Player target;

    public Enemy(int HP, int AR, Weapon weapon, int level, int roll, String weakType, String type, EntityClass.Classes Class)
    {
        super(HP, AR, weapon, level, weakType, type, false, Class);
        this.health = HP;
		this.armor = AR;
		this.weapon = weapon;
        this.level = level;
        this.roll = roll;
		this.weakType = weakType;
		this.type = type;
        this.Class = Class;
        enemyList.add(this);
    }

    // Add enemy turn and enemy action
    public void enemyTurn()
    {
        // add enemy turn code here
    }

    public int enemyAttack()
    {
        target = FightProcesses.getTarget();
        int targetHP = target.getHealth();
        if(weapon.getHasEffect()){weapon.effectProcess(target);}
        if(FightProcesses.attackRoll(roll) > target.getArmor())
        {
            targetHP -= weapon.getDamage();
        }

        return targetHP;
    }

    public static ArrayList<Enemy> getEnemyList()
    {
        return enemyList;
    }
}
