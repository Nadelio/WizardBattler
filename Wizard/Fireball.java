package Wizard;
import Game.FightProcesses;
import Game.Turn;
import Game.Entity;

public class Fireball extends Spell
{

    public Fireball()
    {
        super(true, 3, "FIRE", "Fireball");
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetHealth = target.getHealth();
        int burnDuration = 3;
        Turn lastTurn = FightProcesses.getTurnData(FightProcesses.getTurn() - 2);
        Turn currentTurn = FightProcesses.getTurnData(FightProcesses.getTurn() - 1);
        if(lastTurn != currentTurn && burnDuration > 0)
        {
            targetHealth -= 1;
            burnDuration -= 1;
        }
    } 
}
