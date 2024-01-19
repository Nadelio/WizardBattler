package Game;

import java.util.*; // gives various utilites

import Classes.EntityClass;
import Classes.Wizard;
import Fighter.FighterActions;
import WMath.*;
import Weapons.Weapon;
import Wizard.*;

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
    private FighterActions currentActions;
    private int turnDamage;
    private boolean frozen = false;

    private static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

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
        if(target == null){chooseTarget();}
        if(!frozen)
        {
            if(!target.getDodged())
            {
                if(getHealth() < 25){enemyAction();}
                else if(getCurrentTarget().getHealth() < 25 || (getCurrentTarget().getHealth() > 75 && getHealth() > 75)){getCurrentTarget().setHealth(getCurrentTarget().getHealth() - enemyAttack());}
                else{getCurrentTarget().setHealth(getCurrentTarget().getHealth() - enemyAttack());}
            }
        }
        FightProcesses.nextTurn();
    }

    public void enemyAction()
    {
        if(this.Class.equals(EntityClass.Classes.Wizard))
        {
            if(Math.random() > 0.5){doStaffAttacks();}
            else{doStaffAbility();}
        }
        else if(this.Class.equals(EntityClass.Classes.Fighter))
        {
            if(Math.random() > 0.5){doAttack();}
            else{doAction();}
        }
        FightProcesses.nextTurn();
    }

    public int enemyAttack()
    {
        target = FightProcesses.getPlayerTarget();
        int targetHP = target.getHealth();
        if(weapon.getHasEffect()){weapon.effectProcess(target);}
        if(FightProcesses.attackRoll(roll) > target.getArmor())
        {
            targetHP -= weapon.getDamage();
        }
        this.turnDamage = target.getHealth() - targetHP;
        return targetHP;
    }

    public String getSpellChoice()
    {
        Spells choices = Wizard.getSpells(getLevel());
        Spell[] ENEMYSPELL = choices.getSpellInventory();
        return ENEMYSPELL[WMath.randInt(0, ENEMYSPELL.length)].getName();
    }

    public void doAttack()
    {
        System.out.println("No Enemy AI implemented yet!");
        // add AI logic here
    }

    public void doAction()
    {
        System.out.println("No Enemy AI implemented yet!");
        // add AI logic here
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

    private void chooseTarget(){this.target = Player.getPlayerList().get(WMath.randInt(0, Player.getPlayerList().size() - 1));}

    public static ArrayList<Enemy> getEnemyList(){return enemyList;}
    public static Enemy getEnemyFromList(String entityname)
    {
        for(Enemy enemy : getEnemyList()){if(enemy.getName().equals(entityname)){return enemy;}}
        return null;
    }

    @Override
    public String toString(){return entityName;}
}
