package Paladin;

import Game.Entity;
import Game.FightProcesses;

public class HealingPrayer extends PaladinAction
{
    public HealingPrayer()
    {
        super(true, 0, "HOLY", "Healing_prayer", false);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetHealth = target.getHealth();
        target.setHealth(targetHealth + FightProcesses.getTurnData(FightProcesses.getTurnCount() - 1).getMemberInPlay().getLevel() + 2);
    }
}
