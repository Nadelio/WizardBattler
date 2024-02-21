package Wizard;

import Game.Actions;

public class Spells extends Actions
{
    private Spell[] actionInventory;
    private Spell currentSpell;

    public Spell[] getActionInventory(){return actionInventory;}
    public Spells(Spell[] SPELLINV){this.actionInventory = SPELLINV;}


    public Spell getCurrentSpell(){return currentSpell;}
}
