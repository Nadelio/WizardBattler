package Archer;

import Game.Entity;
import Game.FightProcesses;

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
                System.out.println("Detected turn update!");
                target.setFrozen();
                duration--;
                try {Thread.sleep(50);} catch(InterruptedException e){}
            }
        }
        target.setUnfrozen();
    }
}