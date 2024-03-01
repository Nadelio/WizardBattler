package Events;

import Game.Entity;

public class HealthChangedEvent extends Events
{
    private String eventName = "HealthChanged";
    
    @Override
    public void event(Entity target, int healthChangedAmount)
    {
        System.out.println(target + "'s health changed by " + healthChangedAmount + " points!");
    }
}
