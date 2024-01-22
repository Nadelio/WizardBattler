package Fighter;

import Game.Actions;

public class FighterActions extends Actions
{
    private FighterAction[] actionInventory;
    private FighterAction currentAction;
    
    public FighterActions(FighterAction[] ACTIONINV){this.actionInventory = ACTIONINV;}

    
    public FighterAction[] getActionInventory(){return actionInventory;}
    public FighterAction getCurreAction(){return currentAction;}
}
