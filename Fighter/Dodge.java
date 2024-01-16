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
        Entity memberInPlay = FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay();
        memberInPlay.setDodged();
        while(memberInPlay.getDodged())
        {
            if(FightProcesses.turnUpdate)
            {
                memberInPlay.setDodged();
                try {Thread.sleep(50);} catch(InterruptedException e){}
            }
        }
    }
}
