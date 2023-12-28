package Events;

import Game.Events;
import Game.FightProcesses;

public class HealthChangedEvent extends Events
{
    private String eventName = "HealthChanged";
    
    @Override
    public void event()
    {
        if(FightProcesses.getTurn() != 0)
        {
            System.out.println(FightProcesses.getTurnData(FightProcesses.getTurn()).getMemberInPlay().getHealth() - FightProcesses.getTurnData(FightProcesses.getTurn() - 1).getMemberInPlay().getHealth());
        }
        else
        {
            System.out.println("0");
        }
    }
}
