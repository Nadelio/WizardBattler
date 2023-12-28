package Events;

import Game.Events;
import Game.FightProcesses;

public class EntityDeathEvent extends Events
{
    
    private String eventName = "EntityDeath";
    
    @Override
    public void event()
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurn()).getMemberInPlay().getCurrentTarget() + "died!");
    }    
}
