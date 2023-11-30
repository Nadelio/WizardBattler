package Game;

import java.util.ArrayList;
import java.util.Random;

public class Entity
{
    private static ArrayList<Entity> entityList;
    private int HP;
    private int AR;
    private Weapon weapon;
    private int level;
    private int roll;
    private String weakType;
    private String strongType;
    private boolean entityType;
    private EntityClass Class;
    
    public Entity(int HP, int AR, Weapon weapon, int level, String weakType, String strongType, boolean entityType, EntityClass Class)
    {
        this.HP = HP;
        this.AR = AR;
        this.weapon = weapon;
        this.level = level;
        Random random = new Random();
        this.roll = random.nextInt(level, level + 4);
        this.weakType = weakType;
        this.strongType = strongType;
        this.entityType = entityType;
        this.Class = Class;
        
        if(entityType){new Player(HP, AR, weapon, level, this.roll, weakType, Class);}
        else{new Enemy(HP, AR, weapon, level, this.roll, weakType, strongType, Class);}
        entityList.add(this);
    }

    public static ArrayList<Entity> getEntityList()
    {
        return entityList;
    }

    public int getHealth(){return HP;}
    public int getArmor(){return AR;}
    public Weapon getWeapon(){return weapon;}
    public int getLevel(){return level;}
    public int getRoll(){return roll;}
    public String getWeakType(){return weakType;}
    public String getStrongType(){return strongType;}
    public boolean getEntityType(){return entityType;}
    public EntityClass getEntityClass(){return Class;}

    public String toString()
    {
        if(entityType){return "Player";}
        return "Enemy";
    }
}
