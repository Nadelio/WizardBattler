package Paladin;

import Game.Actions;
public class PaladinActions extends Actions
{
    private PaladinAction[] actionInventory;
    private PaladinAction currentAction;
    
    public PaladinActions(PaladinAction[] ACTIONINV){this.actionInventory = ACTIONINV;}
    
    public PaladinAction[] getActionInventory(){return actionInventory;}
    public PaladinAction getCurreAction(){return currentAction;}
}
