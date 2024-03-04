package Game;

import Classes.EntityClass;
import Events.*;
import WMath.*;
import Weapons.Weapon;

public class Enemy extends Entity
{
    private int totalHealth;
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
        this.totalHealth = HP;
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
                if(getHealth() < (totalHealth/2)){enemyAction();}
                else if(target.getHealth() < 25 || (target.getHealth() > 75 && getHealth() > 75)){target.setHealth(enemyAttack());}
                else{target.setHealth(enemyAttack());}
            }
            else
            {
                System.out.println(target.getName() + " dodged!");
                target.setDodged();
            }
        }
        else
        {
            System.out.println(this.getName() + " is frozen!");
            this.setUnfrozen();
        }
        FightProcesses.nextTurn();
    }

    public void enemyAction()
    {
        if(this.weapon.getWeaponType().equals("staff"))
        {
            if(Math.random() > 0.5){doStaffAttacks();}
            else{doStaffAbility();}
        }
        else
        {
            if(Math.random() > 0.5){target.setHealth(enemyAttack());}
            else{doAction();}
        }
        FightProcesses.nextTurn();
    }

    public int enemyAttack()
    {
        new AttackPlayedEvent().event();
        target = FightProcesses.getPlayerTarget();
        int targetHP = target.getHealth();
        if(weapon.getHasEffect() && weapon.getEffectIsHarmful()){new WeaponEffectUsedEvent().event(); weapon.effectProcess(target);}
        else if(weapon.getHasEffect() && !weapon.getEffectIsHarmful()){new WeaponEffectUsedEvent().event(); weapon.effectProcess(this);}
        if(FightProcesses.attackRoll(roll) > target.getArmor())
        {
            new WeaponUsedEvent().event();
            targetHP -= weapon.getDamage();
        }
        this.turnDamage = target.getHealth() - targetHP;
        new DamageGivenEvent().event(turnDamage);
        new DamageTakenEvent().event(target, turnDamage);
        new HealthChangedEvent().event(target, turnDamage);
        return targetHP;
    }

    public void doStaffAttacks()
    {
        String choice = getActionChoice();
        int targetHP = target.getHealth();
        if(Environment.spellDatabase.get(choice).getIsHarmful())
        {
            new AttackPlayedEvent().event();
            target.setHealth(currentActions.chooseAction(Environment.spellDatabase.get(choice), target));
            this.turnDamage = target.getHealth() - targetHP;
            new DamageGivenEvent().event(turnDamage);
            new DamageTakenEvent().event(target, turnDamage);
            new HealthChangedEvent().event(target, turnDamage);
        }
        else{doStaffAttacks();}
    }

    public void doStaffAbility()
    {

        String choice = getActionChoice();
        if(!Environment.spellDatabase.get(choice).getIsHarmful())
        {
            new ActionPlayedEvent().event();
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
            new ActionPlayedEvent().event();
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
