package Events;

import Game.Events;
import Game.FightProcesses;

public class DamageTakenEvent extends Events
{
    private String eventName = "DamageTaken";

    @Override
    public void event()
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurn()).getMemberInPlay().getCurrentTarget() + "took " + FightProcesses.getTurnData(FightProcesses.getTurn()).getMemberInPlay().getTurnDamage() + " damage!");
    }
}

