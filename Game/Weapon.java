package Game;

public class Weapon
{
    private int damage;
    private boolean hasEffect;
    private String damageType;
    private String weaponName;

    public Weapon(int damage, boolean hasEffect, String damageType, String weaponName)
    {
        this.damage = damage;
        this.hasEffect = hasEffect;
        this.damageType = damageType;
        this.weaponName = weaponName;
    }

    public int getDamage(){return damage;}
    public boolean getHasEffect(){return hasEffect;}
    public String getDamageType(){return damageType;}
    public String getWeaponName(){return weaponName;}

    public void effectProcess(Entity entity){}
}
