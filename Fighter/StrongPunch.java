package Fighter;

import Game.Entity;
import Game.FightProcesses;

public class StrongPunch extends FighterAction
{
    public StrongPunch()
    {
        super(true, 5, "NONE", "Strong_punch", true);
    }

    @Override
    public void effectProcess(Entity target)
    {
        target.setHealth(target.getHealth() - (int)((this.getActionDamage() * FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getLevel()) / 2));
    }
}
