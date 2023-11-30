import Game.Enemy; // gives Enemy data type
import Game.FightProcesses; // gives attackRoll() and gives currentPlayer

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
        Enemy currentEnemy = FightProcesses.getCurrentEnemy();
        int enemyHealth = currentEnemy.getHealth();
        Spell currentSpell = Spell.SPELLS.get(spellName);
        
        if(FightProcesses.attackRoll(FightProcesses.getCurrentPlayer().getRoll()) > currentEnemy.getArmor())
        {
            if(currentSpell.getHasEffect()){currentSpell.effectProcess(currentEnemy);}
            enemyHealth -= currentSpell.getSpellDamage();

            String TYPE = currentSpell.getType();

            if(TYPE == currentEnemy.getWeakType())
            {
                enemyHealth -= currentSpell.getSpellDamage();
            }
        }

        return enemyHealth;
    }
}
