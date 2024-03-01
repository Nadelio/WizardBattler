package Events;

import Game.Entity;

public class LevelUpEvent extends Events
{
    private String eventName = "LevelUp";
    
    @Override
    public void event(Entity target)
    {
        System.out.println(target.getName() + " leveled up to level: " + target.getLevel() + "!");
    }
}
