package Fighter;

import Game.Entity;
import Game.FightProcesses;

public class FighterActions
{
    private FighterAction[] actionInventory;
    private FighterAction currentAction;
    
    public FighterActions(FighterAction[] ACTIONINV){this.actionInventory = ACTIONINV;}
    
    public int chooseAction(FighterAction action)
    {
        currentAction = action;
        return useAction(action.getName());
    }
    
    public int useAction(String spellName)
    {
        Entity currentTarget = FightProcesses.getTurnData(FightProcesses.getTurn() - 1).getMemberInPlay().getCurrentTarget();
        int targetHealth = currentTarget.getHealth();
        
        if(FightProcesses.attackRoll(FightProcesses.getTurnData(FightProcesses.getTurn() - 1).getMemberInPlay().getRoll()) > currentTarget.getArmor())
        {
            if(currentAction.getHasEffect() && currentAction.getIsHarmful()){currentAction.effectProcess(currentTarget);}
            else if(currentAction.getHasEffect() && (currentAction.getIsHarmful() == false)){currentAction.effectProcess(FightProcesses.getTurnData(FightProcesses.getTurn()).getMemberInPlay());}
            targetHealth -= currentAction.getActionDamage();
            
            String TYPE = currentAction.getType();
            
            if(TYPE == currentTarget.getWeakType())
            {
                targetHealth -= currentAction.getActionDamage();
            }
        }
        
        return targetHealth;
    }
    
    public FighterAction[] getActionInventory(){return actionInventory;}
    public FighterAction getCurreAction(){return currentAction;}
}
