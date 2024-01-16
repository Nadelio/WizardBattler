package Wizard;

import Game.Entity;
import Game.FightProcesses;

public class Poison extends Spell
{
    public Poison()
    {
        super(true, 2, "POISON", "Poison", true);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetHealth = target.getHealth();
        int poisonDuration = 5;
        while(poisonDuration > 0)
        {
            while(FightProcesses.turnUpdate)
            {
                target.setHealth(targetHealth - 1);
                poisonDuration--;
            }
        }
    }
}
