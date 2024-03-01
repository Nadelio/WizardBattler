package Events;

import Game.Entity;

public class Events
{
    private String eventName;


    public void event(){}

    public void event(int number){}

    public void event(Entity target){}

    public void event(Entity target, int number){}

    public String getEventName(){return eventName;}

    public String toString(){return eventName;}
}
