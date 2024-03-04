package Archer;

import Game.Entity;
import Game.FightProcesses;

public class FireArrow extends ArcherAction
{
    public FireArrow()
    {
        super(true, 3, "FIRE", "Fire_arrow", true);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetHealth = target.getHealth();
        int burnDuration = 3;
        while(burnDuration > 0)
        {
            if(FightProcesses.turnUpdate)
            {
                System.out.println("Detected turn update!");
                target.setHealth(targetHealth - 1);
                burnDuration--;
                try {Thread.sleep(50);} catch(InterruptedException e){}
            }
        }
    }
}
