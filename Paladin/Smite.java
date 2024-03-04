package Paladin;

import Game.Entity;
import Game.FightProcesses;

public class Smite extends PaladinAction
{
    public Smite()
    {
        super(true, 20, "HOLY", "Smite", true);
    }

    @Override
    public void effectProcess(Entity target)
    {
        Entity user = FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay();
        user.setDodged();
        while(user.getDodged())
        {
            if(FightProcesses.turnUpdate)
            {
                System.out.println("Detected turn update!");
                user.setDodged();
                try {Thread.sleep(50);} catch(InterruptedException e){}
            }
        }
    }
}
