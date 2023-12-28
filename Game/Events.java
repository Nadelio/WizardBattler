package Game;

import Events.*;

public class Events
{
    private boolean isActive;
    private String eventName;
    public static String[] EVENTS = {"DamageTaken","DamageGiven","HealthChanged","TurnPlayed","WeaponUsed","WeaponEffectUsed","SpellEffectUsed","SpellUsed","EntityDeath","ActionPlayed","AttackPlayed"};
    public static final Events[] eventList = {new DamageTakenEvent(), new DamageGivenEvent(), new HealthChangedEvent()};

    public void event()
    {
        this.isActive = true;
        // do event stuff here
        this.isActive = false;
    }

    public static void doEvent(String eventName)
    {
        if(getEvent(eventName) != null)
        {
            getEvent(eventName).event();
        }
        else
        {
            System.out.println("Error: Event does not exist");
        }
    }

    public static Events getEvent(String eventName)
    {
        for(Events event : eventList)
        {
            if(event.getEventName().equals(eventName))
            {
                return event;
            }
        }
        return null;
    }

    public String getEventName(){return eventName;}
}
