package Game;

import java.util.*; // gives various utilites

import Classes.Wizard;
import Wizard.*;
import math.*;

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
    private Spells currentSpells;

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

    public void enemyTurn()
    {
        if(getHealth() < 25){enemyAction();}
        else if(getCurrentTarget().getHealth() < 25 || (getCurrentTarget().getHealth() > 75 && getHealth() > 75)){enemyAttack();}
        else{getCurrentTarget().setHealth(getCurrentTarget().getHealth() - enemyAttack());}
    }

    public void enemyAction()
    {
        if(this.Class.equals(EntityClass.Classes.Wizard))
        {
            if(Math.random() > 0.5){doStaffAttacks();}
            else{doStaffAbility();}
        }
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

    public String getSpellChoice()
    {
        Spells choices = Wizard.getSpells(getLevel());
        Spell[] ENEMYSPELL = choices.getSpellInventory();
        return ENEMYSPELL[math.randInt(0, ENEMYSPELL.length)].getName();
    }

    public void doStaffAttacks()
    {
        String choice = getSpellChoice();
        if(Spell.SPELLS.get(choice).getIsHarmful())
        {
            getCurrentTarget().setHealth(currentSpells.chooseSpell(Spell.SPELLS.get(choice)));
        }
        else{doStaffAttacks();}
    }

    public void doStaffAbility()
    {
        String choice = getSpellChoice();
        if(!Spell.SPELLS.get(choice).getIsHarmful())
        {
            getCurrentTarget().setHealth((currentSpells.chooseSpell(Spell.SPELLS.get(choice))));
        }
        else{doStaffAbility();}
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
