package Fighter;

import Game.Entity;
import Game.Environment;
import Game.FightProcesses;

public class StrongPunch extends FighterAction
{
    public StrongPunch()
    {
        super(true, 0, "NONE", "Strong_punch", true);
    }

    @Override
    public void effectProcess(Entity target)
    {
        target.setHealth(target.getHealth() - Math.round((5 * Environment.entityList.get(FightProcesses.getTurnIterateNumber()).getLevel()) / 2));
    }
}
