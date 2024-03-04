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
        int targetArmor = target.getArmor();
        target.setArmor(0);
        while(true)
        {
            if(FightProcesses.turnUpdate)
            {
                System.out.println("Detected turn update!");
                target.setArmor(targetArmor);
                break;
            }
        }
    }
}
