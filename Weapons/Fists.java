package Weapons;

public class Fists extends Weapon
{
    public Fists(int level)
    {
        super(2 * level, false, "NONE", "fists", "fists", false);
    }

    public Fists()
    {
        super(2, false, "NONE", "fists", "fists", false);
    }    
}
