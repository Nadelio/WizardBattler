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
}
