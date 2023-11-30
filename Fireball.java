import Game.Enemy;

public class Fireball extends Spell
{

    public Fireball()
    {
        super(true, 3, "FIRE", "Fireball");
    }

    @Override
    public void effectProcess(Enemy enemy)
    {
        int enemyHealth = enemy.getHealth();
        int burnDuration = 3;
        Turn lastTurn = getTurnData(FightProcess.getTurn() - 2);
        Turn currentTurn = getTurnData(FightProcess.getTurn() - 1);
        if(lastTurn != currentTurn && burnDuration > 0)
        {
            enemyHealth -= 1;
            burnDuration -= 1;
        }
    } 
}
