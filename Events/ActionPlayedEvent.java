package Events;

import Game.Events;

public class ActionPlayedEvent extends Events
{
    private String eventName = "ActionPlayed";
    
    @Override
    public void event()
    {
        System.out.println("Attack chosen!");
    }
}
