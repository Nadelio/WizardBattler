import Game.Enemy; // gives Enemy data type
import Game.FightProcesses; // gives attackRoll() and gives currentPlayer

public class Spells
{
    private Spell[] spellInventory;
    private Spell currentSpell;

    public Spell[] getSpellInventory(){return spellInventory;}
    public Spell getCurrentSpell(){return currentSpell;}
    public Spells(Spell[] SPELLINV){this.spellInventory = SPELLINV;}

    public void chooseSpell(Spell spell)
    {
        currentSpell = spell; // update this to actually do choosing instead of a manual selection, think key:value, where Spell.name is the key, and the Spell instance is the value
    }

    public int useSpell()
    {
        Enemy currentEnemy = FightProcesses.getCurrentEnemy();
        int enemyHealth = currentEnemy.getHealth();
        
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
