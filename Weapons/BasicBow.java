package Weapons;

public class BasicBow extends Weapon
{
    public BasicBow(int level)
    {
        super(2 * level, false, "NONE", "basic_bow", "bow");
    }

    public BasicBow()
    {
        super(2, false, "NONE", "basic_bow", "bow");
    }
}
