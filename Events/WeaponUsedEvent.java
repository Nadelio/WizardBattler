package Events;

import Game.FightProcesses;

public class WeaponUsedEvent extends Events
{
    private String eventName = "WeaponUsed";

    @Override
    public void event()
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getWeapon() + " used!");
    }
}
