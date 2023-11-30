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
        // add 1 burn damage over turns
    } 
}
