package Paladin;

import Game.Entity;
import Game.FightProcesses;

public class PaladinActions 
{
    private PaladinAction[] actionInventory;
    private PaladinAction currentAction;
    
    public PaladinActions(PaladinAction[] ACTIONINV){this.actionInventory = ACTIONINV;}
    
    public int chooseAction(PaladinAction action)
    {
        currentAction = action;
        return useAction(action.getName());
    }
    
    public int useAction(String spellName)
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
    
    public PaladinAction[] getActionInventory(){return actionInventory;}
    public PaladinAction getCurreAction(){return currentAction;}
}
