package Fighter;

import Game.Entity;
import Game.FightProcesses;

public class TriplePunch extends FighterAction
{
    public TriplePunch()
    {
        super(true, 4, "NONE", "Triple_punch", true);
    }

    @Override
    public void effectProcess(Entity target)
    {
        target.setHealth(target.getHealth() - (this.getActionDamage() * FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getLevel()));
    }
}
