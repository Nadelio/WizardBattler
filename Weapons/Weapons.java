package Weapons;

import java.util.ArrayList;

import WMath.WMath;

public class Weapons
{
    public static ArrayList<Weapon> weaponDatabase = new ArrayList<Weapon>();

    public Weapons()
    {
        weaponDatabase.add(new BasicBow());
        weaponDatabase.add(new BasicSpear());
        weaponDatabase.add(new BasicSword());
        weaponDatabase.add(new BasicStaff());
        weaponDatabase.add(new Fists());
    }

    public static Weapon getWeapon(int level)
    {
        Weapon weapon = weaponDatabase.get(WMath.randInt(0, weaponDatabase.size() - 1));
        weapon.setLevel(level);
        return weapon;
    }

    public static Weapon getWeapon(int level, String type)
    {
        Weapon weapon = weaponDatabase.get(WMath.randInt(0, weaponDatabase.size() - 1));
        while(!weapon.getDamageType().equals(type))
        {
            weapon = weaponDatabase.get(WMath.randInt(0, weaponDatabase.size() - 1));
            if(weapon.getDamageType().equals(type))
            {
                break;
            }
        }
        weapon.setLevel(level);
        return weapon;
    }
}
