package Archer;

import Game.Actions;

public class ArcherActions extends Actions
{
    private ArcherAction[] actionInventory;
    private ArcherAction currentAction;
    
    public ArcherActions(ArcherAction[] ACTIONINV){this.actionInventory = ACTIONINV;}
    
    public ArcherAction[] getActionInventory(){return actionInventory;}
    public ArcherAction getCurreAction(){return currentAction;}
}
