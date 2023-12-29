package Wizard;
import Game.FightProcesses;
import Game.Turn;
import Game.Entity;

public class Fireball extends Spell
{

    public Fireball()
    {
        super(true, 3, "FIRE", "Fireball", true);
    }

    @Override
    public void effectProcess(Entity target)
    {
        int targetHealth = target.getHealth();
        int burnDuration = 3;
        Turn lastTurn = FightProcesses.getTurnData(FightProcesses.getTurn() - 1);
        Turn currentTurn = FightProcesses.getTurnData(FightProcesses.getTurn());
        while(burnDuration > 0)
        {
            while(lastTurn.equals(currentTurn))
            {
                target.setHealth(targetHealth - 1);
                burnDuration--;
            }
        }
    } 
}
