package Game;

import Classes.EntityClass;
import Events.ActionPlayedEvent;
import Events.AttackPlayedEvent;
import WMath.*;
import Weapons.Weapon;

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
    private Actions currentActions;
    private int turnDamage;
    private boolean frozen = false;
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
        this.currentActions = Actions.getClassActions(Class);

        Environment.enemyList.add(this);
    }

    public void enemyTurn()
    {
        if(target == null){chooseTarget();}
        if(!frozen)
        {
            if(!target.getDodged())
            {
                if(getHealth() < 25){enemyAction();}
                else if(target.getHealth() < 25 || (target.getHealth() > 75 && getHealth() > 75)){target.setHealth(target.getHealth() - enemyAttack());}
                else{target.setHealth(target.getHealth() - enemyAttack());}
            }
            else
            {
                System.out.println(target.getName() + " dodged!");
            }
        }
        else
        {
            System.out.println(this.getName() + " is frozen!");
        }
        FightProcesses.nextTurn();
    }

    public void enemyAction()
    {
        new ActionPlayedEvent().event();
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
        new AttackPlayedEvent().event();
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
        if(Environment.spellDatabase.get(choice).getIsHarmful())
        {
            getCurrentTarget().setHealth(currentActions.chooseAction(Environment.spellDatabase.get(choice), getCurrentTarget()));
        }
        else{doStaffAttacks();}
    }

    public void doStaffAbility()
    {
        String choice = getActionChoice();
        if(!Environment.spellDatabase.get(choice).getIsHarmful())
        {
            this.setHealth((currentActions.chooseAction(Environment.spellDatabase.get(choice), this)));
        }
        else{doStaffAbility();}
    }

    public String getActionChoice()
    {
        Action[] ENEMYACTION = currentActions.getActionInventory();
        return ENEMYACTION[WMath.randInt(0, ENEMYACTION.length)].getName();
    }

    public void doAction() 
    {
        String choice = getActionChoice();
        if(!Environment.classActionDatabase.get(Class).get(choice).getIsHarmful())
        {
            target.setHealth((currentActions.chooseAction(Environment.classActionDatabase.get(Class).get(choice), target)));
        }
        else{doAction();}
    }

    private void chooseTarget()
    {
        if(Environment.playerList.size() > 1)
        {
            this.target = Environment.playerList.get(WMath.randInt(Environment.playerList.size() - 1));
        }
        else
        {
            this.target = Environment.playerList.get(WMath.randInt(Environment.playerList.size()));
        }
    }

    @Override
    public String toString(){return entityName;}
}
