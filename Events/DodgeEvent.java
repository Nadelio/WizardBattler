package Events;

public class DodgeEvent extends Events
{
    private String eventName = "Dodge";
    
    @Override
    public void event()
    {
        System.out.println("Dodged!");
    }
}
