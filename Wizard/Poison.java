package Wizard;

import Game.Entity;
import Game.FightProcesses;
import Game.Turn;

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
        Turn lastTurn = FightProcesses.getTurnData(FightProcesses.getTurnCount() - 1);
        Turn currentTurn = FightProcesses.getTurnData(FightProcesses.getTurnCount());
        while(poisonDuration > 0)
        {
            while(lastTurn.equals(currentTurn))
            {
                target.setHealth(targetHealth - 1);
                poisonDuration--;
            }
        }
    }
}
