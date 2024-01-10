package Game;

import java.util.HashMap;

public class Weapon
{
    private int damage;
    private boolean hasEffect;
    private String damageType;
    private String weaponName;
    private String weaponType;

    public static HashMap<String, Weapon> WEAPONS = new HashMap<String, Weapon>();

    public Weapon(int damage, boolean hasEffect, String damageType, String weaponName, String weaponType)
    {
        this.damage = damage;
        this.hasEffect = hasEffect;
        this.damageType = damageType;
        this.weaponName = weaponName;
        this.weaponType = weaponType;
        WEAPONS.put(weaponName, this);
    }

    public int getDamage(){return damage;}
    public boolean getHasEffect(){return hasEffect;}
    public String getDamageType(){return damageType;}
    public String getWeaponName(){return weaponName;}
    public String getWeaponType(){return weaponType;}

    public void effectProcess(Entity entity){}
}
