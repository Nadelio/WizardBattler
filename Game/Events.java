package Game;

public class Events
{
    private boolean isActive;
    private String eventName;
    public static String[] EVENTS = {/*put all eventName's in here*/}

    public Events(String eventName){this.eventName = eventName;}
    
    public static void doEvent(String eventName)
    {
        this.isActive = true;
        if(EVENTS.contains(eventName)
        {
            // @Override, then
            // do something
        }
        this.isActive = false;
    }
}
