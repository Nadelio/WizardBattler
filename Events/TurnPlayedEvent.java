package Events;

import Game.Events;
import Game.FightProcesses;

public class TurnPlayedEvent extends Events
{
    private String eventName = "TurnPlayed";

    @Override
    public void event()
    {
        System.out.println("It is turn: " + FightProcesses.getTurnCount());
    }
}
