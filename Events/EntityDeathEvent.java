package Events;

import Game.FightProcesses;

public class EntityDeathEvent extends Events
{
    
    private String eventName = "EntityDeath";
    
    @Override
    public void event()
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getCurrentTarget() + "died!");
    }    
}
