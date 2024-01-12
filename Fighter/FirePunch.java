package Fighter;

import Game.Entity;
import Game.FightProcesses;

public class FirePunch extends FighterAction
{
    public FirePunch()
    {
        super(true, 3, "FIRE", "Fire_punch", true);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetHealth = target.getHealth();
        int burnDuration = 1;
        while(burnDuration > 0)
        {
            if(FightProcesses.turnUpdate)
            {
                target.setHealth(targetHealth - 1);
                burnDuration--;
                try {Thread.sleep(50);} catch(InterruptedException e){}
            }
        }
    }
}
