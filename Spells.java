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

    public static int useSpell()
    {
        Enemy currentEnemy = Enemy.getCurrentEnemy();

        if(FightProcesses.attackRoll(currentPlayer.playerRoll) > currentEnemy.getArmor())
        {
            if(currentSpell.getHasEffect()){currentSpell.effectProcess(currentEnemy);}
            currentEnemy.enemyHealth -= currentSpell.getSpellDamage();

            String TYPE = currentSpell.getType();

            if(TYPE == currentEnemy.weakType)
            {
                currentEnemy.enemyHealth -= currentSpell.getSpellDamage();
            }
        }
    }
}
