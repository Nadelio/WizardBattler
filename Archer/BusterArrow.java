package Archer;

import Game.Entity;
import Game.FightProcesses;

public class BusterArrow extends ArcherAction
{
    public BusterArrow()
    {
        super(true, 0, "NONE", "Buster_arrow", true);
    }

    @Override
    public void effectProcess(Entity target)
    {
        boolean effectActive = true;
        int targetArmor = target.getArmor();
        target.setArmor(0);
        while(effectActive)
        {
            if(FightProcesses.turnUpdate)
            {
                target.setArmor(targetArmor);
                effectActive = false;
            }
        }
    }
}
