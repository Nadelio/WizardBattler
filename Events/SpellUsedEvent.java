package Events;

import Game.FightProcesses;

public class SpellUsedEvent extends Events
{
    
    private String eventName = "SpellUsed";
    
    @Override
    public void event()
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getCurrentSpells().getCurrentSpell().getName() + "used!");
    }
}
