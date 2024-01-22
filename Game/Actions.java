package Game;

import Classes.EntityClass;

public class Actions
{

    private Action[] actionInventory;
    private Action currentAction;

    public int chooseAction(Action action)
    {
        currentAction = action;
        return useAction(action.getName());
    }
    
    public int useAction(String actionName)
    {
        Entity currentTarget = FightProcesses.getTurnData(FightProcesses.getTurnCount() - 1).getMemberInPlay().getCurrentTarget();
        int targetHealth = currentTarget.getHealth();
        
        if(FightProcesses.attackRoll(FightProcesses.getTurnData(FightProcesses.getTurnCount() - 1).getMemberInPlay().getRoll()) > currentTarget.getArmor())
        {
            if(currentAction.getHasEffect() && currentAction.getIsHarmful()){currentAction.effectProcess(currentTarget);}
            else if(currentAction.getHasEffect() && (currentAction.getIsHarmful() == false)){currentAction.effectProcess(FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay());}
            targetHealth -= currentAction.getActionDamage();
            
            String TYPE = currentAction.getType();
            
            if(TYPE == currentTarget.getWeakType())
            {
                targetHealth -= currentAction.getActionDamage();
            }
        }
        
        return targetHealth;
    }

    public static Actions getClassActions(EntityClass.Classes Class)
    {
        return Environment.getActions(Class);
    }

    public Action[] getActionInventory(){return actionInventory;}
}
