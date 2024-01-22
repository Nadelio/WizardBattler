package Game;

import java.util.*; // gives various utilites

import Archer.ArcherAction;
import Classes.EntityClass;
import Classes.Paladin;
import Classes.Wizard;
import Fighter.FighterAction;
import Fighter.FighterActions;
import Paladin.PaladinAction;
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
    private Classes.Class CLASS;
    private String entityName;
    private String currentEnvironment;
    private Actions currentActions = new Actions();
    private int turnDamage;
    private boolean frozen = false;

    private static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

    private Player target;

    public Enemy(int HP, int AR, Weapon weapon, int level, int roll, String weakType, String type, EntityClass.Classes Class, String entityName, String currentEnvironment)
    {
        super(HP, AR, weapon, level, weakType, type, false, Class, entityName, currentEnvironment);
        this.health = HP;
		this.armor = AR;
		this.weapon = weapon;
        this.level = level;
        this.roll = roll;
		this.weakType = weakType;
		this.type = type;
        this.Class = Class;
        this.entityName = entityName;
        this.currentEnvironment = currentEnvironment;
        this.CLASS = Environment.classes.get(Class);

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
        else
        {
            if(Math.random() > 0.5){enemyAttack();}
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

    public void doStaffAttacks()
    {
        String choice = getActionChoice();
        if(Spell.SPELLS.get(choice).getIsHarmful())
        {
            getCurrentTarget().setHealth(currentActions.chooseAction(Spell.SPELLS.get(choice), getCurrentTarget()));
        }
        else{doStaffAttacks();}
    }

    public void doStaffAbility()
    {
        String choice = getActionChoice();
        if(!Spell.SPELLS.get(choice).getIsHarmful())
        {
            this.setHealth((currentActions.chooseAction(Spell.SPELLS.get(choice), getCurrentTarget()))); // got to fix this so that it affects the caster, and not the target.
        }
        else{doStaffAbility();}
    }

    public String getActionChoice()
    {
        Actions choices = Classes.Class.getActions(getLevel());
        Action[] ENEMYACTION = choices.getActionInventory();
        return ENEMYACTION[WMath.randInt(0, ENEMYACTION.length)].getName();
    }

    public void doAction() 
    {
        String choice = getActionChoice();
        if(!Action.ActionDatabase.get(choice).getIsHarmful())
        {
            getCurrentTarget().setHealth((currentActions.chooseAction(Action.ActionDatabase.getACTIONS().get(choice), getCurrentTarget())));
        }
        else{doAction();}
    }

    private void chooseTarget(){this.target = Player.getPlayerList().get(WMath.randInt(Player.getPlayerList().size()));}

    public static ArrayList<Enemy> getEnemyList(){return enemyList;}
    public static Enemy getEnemyFromList(String entityname)
    {
        for(Enemy enemy : getEnemyList()){if(enemy.getName().equals(entityname)){return enemy;}}
        return null;
    }

    @Override
    public String toString(){return entityName;}
}
