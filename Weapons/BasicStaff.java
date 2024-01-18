package Weapons;

public class BasicStaff extends Weapon
{
    public BasicStaff(int level)
    {
        super(2 * level, false, "NONE", "basic_staff", "staff", false);
    }

    public BasicStaff()
    {
        super(2, false, "NONE", "basic_staff", "staff", false);
    }
}
