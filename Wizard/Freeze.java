package Wizard;

import Game.Entity;
import Game.FightProcesses;

public class Freeze extends Spell
{
    public Freeze()
    {
        super(true, 0, "ICE", "Freeze", false);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int duration = 2;
        while(duration > 0)
        {
            while(FightProcesses.turnUpdate)
            {
                System.out.println("Detected turn update!");
                target.getCurrentTarget().setFrozen();
                duration--;
                try {Thread.sleep(50);} catch(InterruptedException e){}
            }
        }
    }
}
