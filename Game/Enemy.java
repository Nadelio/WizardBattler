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
    private String entityName;

    private static ArrayList<Enemy> enemyList;

    private Player target;

    public Enemy(int HP, int AR, Weapon weapon, int level, int roll, String weakType, String type, EntityClass.Classes Class, String entityName)
    {
        super(HP, AR, weapon, level, weakType, type, false, Class, entityName);
        this.health = HP;
		this.armor = AR;
		this.weapon = weapon;
        this.level = level;
        this.roll = roll;
		this.weakType = weakType;
		this.type = type;
        this.Class = Class;
        this.entityName = entityName;

        enemyList.add(this);
    }

    // Add enemy turn and enemy action
    public void enemyTurn()
    {
        // when enemyHealth < <some num>, do <action>
        // if targetHealth < <some num> || (targetHealth > <some num> && enemyHealth > <some num>), do enemyAttack()
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

    public static Enemy getEnemyFromList(String enemyST)
    {
        for(Enemy enemy : getEnemyList()){if(enemy.getStrongType().equals(enemyST)){return enemy;}}
        return null;
    }

    public String toString()
    {
        return getStrongType();
    }
}
