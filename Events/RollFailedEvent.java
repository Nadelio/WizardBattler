package Events;

public class RollFailedEvent extends Events
{
    private String eventName = "RollFailed";
    
    @Override
    public void event()
    {
        System.out.println("Roll Failed!");
    }
}
