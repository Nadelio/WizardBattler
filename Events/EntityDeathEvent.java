package Events;

import Game.Entity;

public class EntityDeathEvent extends Events
{
    
    private String eventName = "EntityDeath";
    
    @Override
    public void event(Entity target)
    {
        System.out.println(target.getName() + "died!");
    }    
}
