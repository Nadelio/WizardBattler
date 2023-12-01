package Wizard;

import Game.Entity; // gives Entity data type and various methods
import Game.FightProcesses; // gives various methods

public class Spells
{
    private Spell[] spellInventory;

    public Spell[] getSpellInventory(){return spellInventory;}
    public Spells(Spell[] SPELLINV){this.spellInventory = SPELLINV;}

    public void chooseSpell(Spell spell)
    {
        useSpell(spell.getName());    
    }

    public int useSpell(String spellName)
    {
        Entity currentTarget = FightProcesses.getTurnData(FightProcesses.getTurn() - 1).getMemberInPlay().getCurrentTarget();
        int targetHealth = currentTarget.getHealth();
        Spell currentSpell = Spell.SPELLS.get(spellName);
        
        if(FightProcesses.attackRoll(FightProcesses.getTurnData(FightProcesses.getTurn() - 1).getMemberInPlay().getRoll()) > currentTarget.getArmor())
        {
            if(currentSpell.getHasEffect()){currentSpell.effectProcess(currentTarget);}
            targetHealth -= currentSpell.getSpellDamage();

            String TYPE = currentSpell.getType();

            if(TYPE == currentTarget.getWeakType())
            {
                targetHealth -= currentSpell.getSpellDamage();
            }
        }

        return targetHealth;
    }
}
