package Events;

import Game.Events;
import Game.FightProcesses;

public class DamageGivenEvent extends Events
{
    private String eventName = "DamageGiven";

    @Override
    public void event()
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurn()).getMemberInPlay() + "dealt" + FightProcesses.getTurnData(FightProcesses.getTurn()).getMemberInPlay().getTurnDamage() + "damage!");
    }
}
