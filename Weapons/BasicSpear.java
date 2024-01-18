package Weapons;

public class BasicSpear extends Weapon
{
    public BasicSpear(int level)
    {
        super(3 * level, false, "NONE", "basic_spear", "spear");
    }

    public BasicSpear()
    {
        super(3, false, "NONE", "basic_spear", "spear");
    }
}
