package Fighter;

import Game.Entity;
import Game.FightProcesses;

public class Toughen extends FighterAction
{
    public Toughen()
    {
        super(true, 0, "NONE", "Toughen", false);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int memberArmor = target.getArmor();
        target.setArmor(target.getArmor() + target.getLevel());
        while(true)
        {
            if(FightProcesses.turnUpdate)
            {
                target.setArmor(memberArmor);
                break;
            }
        }
    }
}
