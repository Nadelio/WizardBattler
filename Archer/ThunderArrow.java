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
        while(duration > 0)
        {
            if(FightProcesses.turnUpdate)
            {
                target.setFrozen();
                duration--;
            }
        }
        target.setUnfrozen();
    }
}