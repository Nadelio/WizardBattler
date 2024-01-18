package Weapons;

import java.util.HashMap;

import Game.Entity;

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

    public void setDamage(int newDamage){this.damage = newDamage;}
    public void setLevel(int level){this.setDamage(this.getDamage() * level);}

    public void effectProcess(Entity entity){}
}
