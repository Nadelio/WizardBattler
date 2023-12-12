package Game;

import java.util.Arrays;

public class Events
{
    private boolean isActive;
    private String eventName;
    public static String[] EVENTS = {/*put all eventName's in here*/};

    public Events(String eventName){this.eventName = eventName;}
    
    public void doEvent(String eventName)
    {
        this.isActive = true;
        if(Arrays.asList(EVENTS).contains(eventName))
        {
            // @Override, then
            // do something
        }
        this.isActive = false;
    }
}
