package Fighter;

import Events.DodgeEvent;
import Game.Entity;

public class Dodge extends FighterAction
{
    public Dodge()
    {
        super(true, 0, "NONE", "Dodge", false);
    }

    @Override
    public void effectProcess(Entity target)
    {
        target.setDodged();
        new DodgeEvent().event();
    }
}
