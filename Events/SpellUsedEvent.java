package Events;

import Game.Events;
import Game.FightProcesses;

public class SpellUsedEvent extends Events
{
    
    private String eventName = "SpellUsed";
    
    @Override
    public void event()
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurn()).getMemberInPlay().getCurrentSpells().getCurrentSpell().getName() + "used!");
    }
}
