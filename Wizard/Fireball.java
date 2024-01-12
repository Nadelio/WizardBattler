package Wizard;
import Game.FightProcesses;
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
        while(burnDuration > 0)
        {
            if(FightProcesses.turnUpdate)
            {
                target.setHealth(targetHealth - 1);
                burnDuration--;
                try {Thread.sleep(50);} catch(InterruptedException e){}
            }
        }
    } 
}
