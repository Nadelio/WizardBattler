package Wizard;

import Game.Entity;
import Game.FightProcesses;

public class Resistance extends Spell
{
    public Resistance()
    {
        super(true, 0, "LIGHT", "Resistance");
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetArmor = target.getArmor();
        target.setArmor(targetArmor + FightProcesses.getTurnData(FightProcesses.getTurn() - 1).getMemberInPlay().getLevel());
    }

}