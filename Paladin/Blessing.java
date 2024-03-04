package Paladin;

import Game.Entity;
import Game.FightProcesses;

public class Blessing extends PaladinAction
{
    public Blessing()
    {
        super(true, 0, "HOLY", "Blessing", false);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetHealth = target.getHealth();
        target.setHealth(targetHealth + target.getLevel() + 4);
        while(true)
        {
            if(FightProcesses.turnUpdate)
            {
                System.out.println("Detected turn update!");
                target.setHealth(target.getHealth() + 4);
                break;
            }
        }
    }
}
