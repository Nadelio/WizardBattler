package Events;

public class ActionPlayedEvent extends Events
{
    private String eventName = "ActionPlayed";
    
    @Override
    public void event()
    {
        System.out.println("Action chosen!");
    }
}
