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
        memberInPlay.setArmor(memberInPlay.getArmor() + memberInPlay.getLevel());
    }
}
