package Events;

import Game.FightProcesses;

public class DamageGivenEvent extends Events
{
    private String eventName = "DamageGiven";

    @Override
    public void event(int damageGiven)
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay() + " dealt " + damageGiven + " damage!");
    }
}
