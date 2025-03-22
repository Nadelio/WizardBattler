import game.Data;
import game.Effect;
import classes.GameClass;

public class Player {
    private String name;
    private GameClass playerClass;
    private int xp;
    private int level;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private int speed;
    private Effect[] effects;

    private boolean dead = false;

    public Player(String name, GameClass playerClass, int xp, int level, int health, int maxHealth, int attack, int defense, int speed) {
        this.name = name;
        this.playerClass = playerClass;
        this.xp = xp;
        this.level = level;
        this.health = health;
        this.maxHealth = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.effects = new Effect[0]; // Initialize with no effects
    }

    private void checkForLevelUp(){
        if (level >= Data.MAX_PLAYER_LEVEL) return; // Prevent level up if max level reached
        
        int levelThreshold = (int) (level * Math.pow(Data.levelUpFactor, level - 1));
        if (xp >= levelThreshold) {
            level++;
            maxHealth += 10; // Increase max health on level up
            health = maxHealth; // Restore health on level up
            attack += 2; // Increase attack on level up
            defense += 1; // Increase defense on level up
            speed += 1; // Increase speed on level up
            System.out.println(name + " leveled up to level " + level + "!");
        }
    }

    public String getName() { return name; }
    public GameClass getPlayerClass() { return playerClass; }
    public int getXp() { return xp; }
    public int getLevel() { return level; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public boolean isDead() { return dead; }
    public Effect[] getEffects() { return effects; }

    public void addXP(int xp) { this.xp += xp; checkForLevelUp(); }
    public void addHealth(int health) { this.health = Math.min(this.health + health, maxHealth); }
    public void subHealth(int health) { this.health = Math.max(0, Math.min(health, maxHealth)); if (this.health == 0) { System.out.println(name + " has been defeated!"); this.dead = true;} }
    
    public void applyEffect(Effect effect) {
        Effect[] newEffects = new Effect[effects.length + 1];
        System.arraycopy(effects, 0, newEffects, 0, effects.length);
        newEffects[effects.length] = effect;
        this.effects = newEffects;
    }

    public void removeEffect(Effect effect) {
        Effect[] newEffects = new Effect[effects.length - 1];
        int index = 0;
        for (Effect e : effects) {
            if (!e.equals(effect)) {
                newEffects[index++] = e;
            }
        }
        this.effects = newEffects;
    }
}