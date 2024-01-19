package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Events.*;
import Classes.*;
import Fighter.*;
import Paladin.*;
import Archer.*;
import Wizard.*;
import Weapons.Weapon;

public class Player extends Entity
{
    private static ArrayList<Player> playerList = new ArrayList<Player>();

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
    private FighterActions currentFighterActions;
    private ArcherActions currentArcherActions;
    private PaladinActions currentPaladinActions;
    private int turnDamage;
    private Entity target;

    private boolean frozen = false;

    public Player(int HP, int AR, Weapon weapon, int level, int roll, String weakType, EntityClass.Classes Class, String entityName)
    {
        super(HP, AR, weapon, level, weakType, "isPlayer", true, Class, entityName);
        this.health = HP;
        this.armor = AR;
        this.weapon = weapon;
        this.level = level;
        this.roll = roll;
        this.weakType = weakType;
        this.type = "isPlayer";
        this.Class = Class;
        this.entityName = entityName;
	    if(Class.equals(EntityClass.Classes.Wizard)){this.currentSpells = Wizard.getSpells(level);}
        else if(Class.equals(EntityClass.Classes.Fighter)){this.currentFighterActions = Fighter.getActions(level);}
        else if(Class.equals(EntityClass.Classes.Archer)){this.currentArcherActions = Archer.getActions(level);}
        else if(Class.equals(EntityClass.Classes.Paladin)){this.currentPaladinActions = Paladin.getActions(level);}

        playerList.add(this);
    }

    // Add player action and action menu
    public void playerAction()
    {
        // do stuff
        FightProcesses.nextTurn();
    }
    
    public void playerAttack()
    {
        System.out.println(entityName + " chose to attack!");
        int staffDamage = 0;
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
                    staffDamage = doStaffAttacks();
	        	    target.setHealth(target.getHealth() - staffDamage);
                    this.turnDamage += staffDamage;
	            }
	            else
	            {
		            if(weapon.getHasEffect() && weapon.getEffectIsHarmful()){new WeaponEffectUsedEvent().event(); weapon.effectProcess(target);}
                    else if(weapon.getHasEffect() && !weapon.getEffectIsHarmful()){new WeaponEffectUsedEvent().event(); weapon.effectProcess(FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay());}
		            
                    if(FightProcesses.attackRoll(roll) >= target.getArmor())
		            {
                        this.turnDamage += playerDamage;
		        	    targetHealth -= playerDamage;
                        new WeaponUsedEvent().event();
		        	    if(target.getWeakType().equals(weapon.getDamageType()))
		        	    {
                            this.turnDamage += playerDamage;
		        		    targetHealth -= playerDamage;
                            new WeaponUsedEvent().event();
		        	    }
		            }
                    target.setHealth(targetHealth);
	            }
                new DamageGivenEvent().event(turnDamage);
                new DamageTakenEvent().event(target, turnDamage);
                new HealthChangedEvent().event(target, turnDamage);
            }
        }
        turnDamage = 0;
        FightProcesses.nextTurn();
    }

    public Enemy chooseTarget()
    {
        System.out.println(Enemy.getEnemyList().toString());
        System.out.print("Input: ");
        Scanner playerInput = new Scanner(System.in);
        String input = playerInput.nextLine();
        for(Enemy enemy : Enemy.getEnemyList()){if(enemy.getName().equals(input.toLowerCase())){return enemy;}}
        return null;
    }

    public int doStaffAttacks()
    {
	    System.out.println(currentSpells.getSpellInventory().toString());
	    Scanner playerInput = new Scanner(System.in);
        String choice = playerInput.nextLine();
        if(Arrays.asList(currentSpells.getSpellInventory()).contains(Spell.SPELLS.get(choice))){return currentSpells.chooseSpell(Spell.SPELLS.get(choice));}
        return doStaffAttacks();
    }

    public static ArrayList<Player> getPlayerList()
    {
        return playerList;
    }

    @Override
    public String toString(){return entityName;}
}
