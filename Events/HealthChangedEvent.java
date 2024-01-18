package Events;

import Game.FightProcesses;

public class HealthChangedEvent extends Events
{
    private String eventName = "HealthChanged";
    
    @Override
    public void event()
    {
        if(FightProcesses.getTurnCount() != 0)
        {
            System.out.println(FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getHealth() - FightProcesses.getTurnData(FightProcesses.getTurnCount() - 1).getMemberInPlay().getHealth());
        }
        else
        {
            System.out.println("0");
        }
    }
}
