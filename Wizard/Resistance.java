package Wizard;

import Game.Entity;

public class Resistance extends Spell
{
    public Resistance()
    {
        super(true, 0, "NONE", "Resistance", false);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetArmor = target.getArmor();
        target.setArmor(targetArmor + target.getLevel());
    }

}
