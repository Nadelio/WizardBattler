package Events;

import Game.Events;

public class AttackPlayedEvent extends Events
{
    private String eventName = "AttackPlayed";
    
    @Override
    public void event()
    {
        System.out.println("Action chosen!");
    }
}
