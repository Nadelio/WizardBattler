package Wizard;

import Game.Entity;
import Game.FightProcesses;

public class Recovery extends Spell
{
    public Recovery()
    {
        super(true, 0, "HOLY", "Recovery", false);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetHealth = target.getHealth();
        if(FightProcesses.getTurnCount() <= 0)
        {
            target.setHealth(targetHealth + target.getLevel());
        }
        else
        {
            target.setHealth(targetHealth + target.getLevel());
        }
    }
}
