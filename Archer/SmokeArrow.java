package Archer;

import Game.Entity;
import Game.FightProcesses;

public class SmokeArrow extends ArcherAction
{
    public SmokeArrow()
    {
        super(true, 0, "NONE", "Smoke_arrow", false);
    }    

    @Override
    public void effectProcess(Entity target)
    {
        target.setDodged();
        while(target.getDodged())
        {
            if(FightProcesses.turnUpdate)
            {
                System.out.println("Detected turn update!");
                target.setDodged();
                try {Thread.sleep(50);} catch(InterruptedException e){}
            }
        }
    }
}
