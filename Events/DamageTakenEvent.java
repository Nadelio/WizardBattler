package Events;

import Game.FightProcesses;

public class DamageTakenEvent extends Events
{
    private String eventName = "DamageTaken";

    @Override
    public void event()
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getCurrentTarget() + "took " + FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getTurnDamage() + " damage!");
    }
}

