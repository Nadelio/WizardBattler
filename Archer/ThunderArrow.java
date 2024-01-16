package Archer;

import Game.Entity;
import Game.FightProcesses;
import Game.Turn;

public class ThunderArrow extends ArcherAction
{
    public ThunderArrow()
    {
        super(true, 3, "LIGHTNING", "Thunder_arrow", true);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int duration = 2;
        Turn lastTurn = FightProcesses.getTurnData(FightProcesses.getTurnCount() - 1);
        Turn currentTurn = FightProcesses.getTurnData(FightProcesses.getTurnCount());
        while(duration > 0)
        {
            while(lastTurn.equals(currentTurn))
            {
                target.setFrozen();
            }
        }
        target.setUnfrozen();
    }
}