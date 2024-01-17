package Fighter;

import Game.Entity;
import Game.FightProcesses;

public class Dodge extends FighterAction
{
    public Dodge()
    {
        super(true, 0, "NONE", "Dodge", false);
    }

    @Override
    public void effectProcess(Entity target)
    {
        target.setDodged();
        while(target.getDodged())
        {
            if(FightProcesses.turnUpdate)
            {
                target.setDodged();
                try {Thread.sleep(50);} catch(InterruptedException e){}
            }
        }
    }
}
