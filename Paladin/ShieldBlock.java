package Paladin;

import Game.Entity;
import Game.FightProcesses;

public class ShieldBlock extends PaladinAction
{
    public ShieldBlock()
    {
        super(true, 0, "NONE", "Shield_block", false);
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
