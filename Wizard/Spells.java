package Wizard;

import Game.Entity; // gives Entity data type and various methods
import Game.FightProcesses; // gives various methods

public class Spells
{
    private Spell[] spellInventory;

    public Spell[] getSpellInventory(){return spellInventory;}
    public Spells(Spell[] SPELLINV){this.spellInventory = SPELLINV;}

    private Spell currentSpell;

    public int chooseSpell(Spell spell)
    {
        currentSpell = spell;
        return useSpell(spell.getName());
    }

    public int useSpell(String spellName)
    {
        Entity currentTarget = FightProcesses.getTurnData(FightProcesses.getTurn() - 1).getMemberInPlay().getCurrentTarget();
        int targetHealth = currentTarget.getHealth();
        
        if(FightProcesses.attackRoll(FightProcesses.getTurnData(FightProcesses.getTurn() - 1).getMemberInPlay().getRoll()) > currentTarget.getArmor())
        {
            if(currentSpell.getHasEffect() && currentSpell.getIsHarmful()){currentSpell.effectProcess(currentTarget);}
            else if(currentSpell.getHasEffect() && (currentSpell.getIsHarmful() == false)){currentSpell.effectProcess(FightProcesses.getTurnData(FightProcesses.getTurn()).getMemberInPlay());}
            targetHealth -= currentSpell.getSpellDamage();

            String TYPE = currentSpell.getType();

            if(TYPE == currentTarget.getWeakType())
            {
                targetHealth -= currentSpell.getSpellDamage();
            }
        }

        return targetHealth;
    }

    public Spell getCurrentSpell(){return currentSpell;}
}
