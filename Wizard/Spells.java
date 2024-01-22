package Wizard;

import Game.Actions;

public class Spells extends Actions
{
    private Spell[] spellInventory;
    private Spell currentSpell;

    public Spell[] getSpellInventory(){return spellInventory;}
    public Spells(Spell[] SPELLINV){this.spellInventory = SPELLINV;}


    public Spell getCurrentSpell(){return currentSpell;}
}
