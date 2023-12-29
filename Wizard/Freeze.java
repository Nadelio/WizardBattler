package Wizard;

import Game.Entity;
import Game.FightProcesses;
import Game.Turn;

public class Freeze extends Spell
{
    public Freeze()
    {
        super(true, 0, "ICE", "Freeze", false);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int duration = 2;
        Turn lastTurn = FightProcesses.getTurnData(FightProcesses.getTurn() - 1);
        Turn currentTurn = FightProcesses.getTurnData(FightProcesses.getTurn());
        while(duration > 0)
        {
            while(lastTurn.equals(currentTurn))
            {
                target.setFrozen();
            }
        }
        target.setUnfrozen();
    }
}
