package Archer;

import Game.Entity;
import Game.FightProcesses;

public class SmokeArrow extends ArcherAction
{
    public SmokeArrow()
    {
        super(true, 0, "NONE", "Smoke_arrow", false);
    }    

    @Override
    public void effectProcess(Entity target)
    {
        Entity memberInPlay = FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay();
        memberInPlay.setDodged();
    }
}
