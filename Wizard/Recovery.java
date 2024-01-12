package Wizard;

import Game.Entity;
import Game.FightProcesses;

public class Recovery extends Spell
{
    public Recovery()
    {
        super(true, 0, "LIGHT", "Recovery", false);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetHealth = target.getHealth();
        target.setHealth(targetHealth + FightProcesses.getTurnData(FightProcesses.getTurnCount() - 1).getMemberInPlay().getLevel());
    }
}
