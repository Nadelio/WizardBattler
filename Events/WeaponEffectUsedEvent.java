package Events;

import Game.FightProcesses;

public class WeaponEffectUsedEvent extends Events
{
    private String eventName = "WeaponEffectUsed";
    
    @Override
    public void event()
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getWeapon() + "used its effect!");
    }
}
