package Game;

import Classes.EntityClass;
import Events.*;

public class Actions
{

    private Action[] actionInventory;
    private Action currentAction;

    public int chooseAction(Action action, Entity target)
    {
        currentAction = action;
        return useAction(action.getName(), target);
    }
    
    public int useAction(String actionName, Entity target)
    {
        Entity currentTarget = target;
        int targetHealth = currentTarget.getHealth();

        if(FightProcesses.attackRoll(Environment.entityList.get(FightProcesses.getTurnIterateNumber()).getRoll()) > currentTarget.getArmor())
        {
            if(currentAction.getHasEffect() && currentAction.getIsHarmful())
            {
                currentAction.effectProcess(currentTarget);
            }
            else if(currentAction.getHasEffect() && (!currentAction.getIsHarmful()))
            {
                currentAction.effectProcess(Environment.entityList.get(FightProcesses.getTurnIterateNumber()));
            }
            targetHealth -= currentAction.getActionDamage();
            
            String TYPE = currentAction.getType();
           
            if(TYPE == currentTarget.getWeakType())
            {
                targetHealth -= currentAction.getActionDamage();
            }
        }
        else
        {
            new RollFailedEvent().event();
        }
        return targetHealth;
    }

    public static Actions getClassActions(EntityClass.Classes Class)
    {
        return Environment.getActions(Class);
    }

    public Action[] getActionInventory(){return actionInventory;}
}
