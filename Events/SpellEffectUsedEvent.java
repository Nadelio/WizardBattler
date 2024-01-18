package Events;

import Game.FightProcesses;

public class SpellEffectUsedEvent extends Events
{
    
    private String eventName = "SpellEffectUsed";
    
    @Override
    public void event()
    {
        System.out.println(FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getCurrentSpells().getCurrentSpell().getName() + "used its effect!");
    }
}