package Weapons;

public class BasicStaff extends Weapon
{
    public BasicStaff(int level)
    {
        super(2 * level, false, "MAGIC", "basic_staff", "staff", false);
    }

    public BasicStaff()
    {
        super(2, false, "MAGIC", "basic_staff", "staff", false);
    }
}
