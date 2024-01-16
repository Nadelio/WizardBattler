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
        Entity memberInPlay = FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay();
        int memberArmor = memberInPlay.getArmor();
        memberInPlay.setArmor(memberInPlay.getArmor() + memberInPlay.getLevel());
        while(true)
        {
            if(FightProcesses.turnUpdate)
            {
                memberInPlay.setArmor(memberArmor);
                break;
            }
        }
    }
}
