package Weapons;

public class BasicSword extends Weapon
{
    public BasicSword(int level)
    {
        super(2 * level, false, "NONE", "basic_sword", "sword");
    }

    public BasicSword()
    {
        super(2, false, "NONE", "basic_sword", "sword");
    }
}
