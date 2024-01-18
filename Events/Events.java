package Events;

import Game.Entity;

public class Events
{
    private String eventName;
    public static String[] EVENTS = {"DamageTaken","DamageGiven","HealthChanged","TurnPlayed","WeaponUsed","WeaponEffectUsed","SpellEffectUsed","SpellUsed","EntityDeath","ActionPlayed","AttackPlayed"};
    public static final Events[] eventList = {new DamageTakenEvent(), new DamageGivenEvent(), new HealthChangedEvent(), new TurnPlayedEvent(), new WeaponUsedEvent(), new WeaponEffectUsedEvent(), new SpellUsedEvent(), new SpellEffectUsedEvent(), new EntityDeathEvent(), new ActionPlayedEvent(), new AttackPlayedEvent()};

    public void event(){}

    public void event(int number){}

    public void event(Entity target, int number){}

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

    public String toString(){return eventName;}
}
