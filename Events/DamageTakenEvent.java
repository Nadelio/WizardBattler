package Events;

import Game.Entity;

public class DamageTakenEvent extends Events
{
    private String eventName = "DamageTaken";

    @Override
    public void event(Entity target, int damageTaken)
    {
        System.out.println(target + " took " + damageTaken + " damage!");
    }
}

