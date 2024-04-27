package Game;

import java.util.Arrays;

import Events.*;
import WMath.WMath;
import Classes.*;
import Weapons.Weapon;

public class Player extends Entity
{
    private int totalHealth;
    private int health;
	private int armor;
	private Weapon weapon;
	private int roll;
    private int level;
    private int currentXP = 0;
	private String weakType;
	private String type;
    private EntityClass.Classes Class;
    private String entityName;
    private Actions currentActions;
    private int turnDamage;
    private Entity target;
    private String currentEnvironment;
    private boolean frozen = false;

    public Player(int HP, int AR, Weapon weapon, int level, int roll, String weakType, EntityClass.Classes Class, String entityName, String currentEnvironment)
    {
        super(HP, AR, weapon, level, weakType, "isPlayer", true, Class, entityName, currentEnvironment);
        this.totalHealth = HP;
        this.health = HP;
        this.armor = AR;
        this.weapon = weapon;
        this.level = level;
        this.roll = roll;
        this.weakType = weakType;
        this.type = "isPlayer";
        this.Class = Class;
        this.entityName = entityName;
        this.currentEnvironment = currentEnvironment;
        this.currentActions = Actions.getClassActions(Class);
        if(this.currentActions == null){throw new IllegalArgumentException("Variable 'currentActions' for " + this.entityName + " is null, please restart!");}

        Environment.playerList.add(this);
    }

    public void playerAction()
    {
        String actionInventoryString = Arrays.toString(this.currentActions.getActionInventory());
        System.out.println(entityName + " chose to use an action!");
        System.out.println(actionInventoryString);
        String choice = Main.playerScanner.nextLine();
        Action chosenAction = Environment.classActionDatabase.get(Class).get(choice);
        if(actionInventoryString.contains(chosenAction.getName()))
        {
            if(this.currentActions == null){throw new IllegalArgumentException("Variable 'currentActions' for " + this.entityName + " is null, please restart!");}
            if(chosenAction.getIsHarmful())
            {
                this.target = chooseTarget();

                while(target == null)
                {
                    System.out.println("Error, target does not exist");
                    this.target = chooseTarget();
                    if(this.target != null){break;}
                }

                target.setHealth(target.getHealth() - currentActions.chooseAction(chosenAction, target)); // enemy just self-distructs sometimes???
            }
            else
            {
                this.setHealth(this.getHealth() + this.currentActions.chooseAction(chosenAction, this));
            }
            FightProcesses.nextTurn();
        }
        else
        {
            playerAction();
        }
    }

    public int staffDamage;

    public void playerAttack()
    {
        System.out.println(entityName + " chose to attack!");
        staffDamage = 0;
        int playerDamage = weapon.getDamage();

	    target = chooseTarget();

        while(target == null)
        {
            System.out.println("Error, target does not exist");
            target = chooseTarget();
            if(target != null){break;}
        }

        int targetHealth = target.getHealth();

        if(!frozen)
        {
            if(!target.getDodged())
            {
	            if(weapon.getWeaponType().equals("staff"))
	            {
                    doStaffAttacks();
                    this.turnDamage += staffDamage;
	            }
	            else
	            {
		            if(weapon.getHasEffect() && weapon.getEffectIsHarmful()){new WeaponEffectUsedEvent().event(); weapon.effectProcess(target);}
                    else if(weapon.getHasEffect() && !weapon.getEffectIsHarmful()){new WeaponEffectUsedEvent().event(); weapon.effectProcess(this);}
		            
                    if(FightProcesses.attackRoll(roll) >= target.getArmor())
		            {
                        this.turnDamage += playerDamage;
		        	    targetHealth -= playerDamage;
                        new WeaponUsedEvent().event();
		        	    if(target.getWeakType().equals(weapon.getDamageType()))
		        	    {
                            this.turnDamage += playerDamage;
		        		    targetHealth -= playerDamage;
                            new CriticalHitEvent().event();
		        	    }
		            }
                    else
                    {
                        System.out.println("Attack roll failed!");
                    }
                    target.setHealth(targetHealth);
	            }
                new DamageGivenEvent().event(turnDamage);
                new DamageTakenEvent().event(target, turnDamage);
                new HealthChangedEvent().event(target, turnDamage);
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
        this.turnDamage = 0;
        FightProcesses.nextTurn();
    }

    public Enemy chooseTarget()
    {
        System.out.println(Environment.enemyList.toString());
        System.out.print("Input: ");
        String input = Main.playerScanner.nextLine();
        for(Enemy enemy : Environment.enemyList){if(enemy.getName().equals(input.toLowerCase())){return enemy;}}
        return null;
    }

    public void doStaffAttacks()
    {
        System.out.println(Arrays.toString(this.currentActions.getActionInventory()));
        String choice = Main.playerScanner.nextLine();
        if(Arrays.toString(currentActions.getActionInventory()).contains(Environment.spellDatabase.get(choice).getName()))
        {
            if(Environment.spellDatabase.get(choice).getIsHarmful())
            {
                target.setHealth(target.getHealth() - currentActions.chooseAction(Environment.spellDatabase.get(choice), target));
                staffDamage = Environment.spellDatabase.get(choice).getActionDamage();
            }
            else
            {
                this.setHealth(health + currentActions.chooseAction(Environment.spellDatabase.get(choice), this));
            }
        }
        else
        {
            doStaffAttacks();
        }
    }

    public int getCurrentXP(){return this.currentXP;}
    public void setCurrentXP(int newXP){this.currentXP = newXP;}
    
    @Override
    public String toString(){return entityName;}
}
