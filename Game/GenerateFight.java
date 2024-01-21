package Game;

import Classes.EntityClass;
import WMath.WMath;
import Weapons.Weapon;
import Weapons.Weapons;

public class GenerateFight
{
    public GenerateFight()
    {
        System.out.println("Generating Fight...");
        Player player = Main.getPlayer();
        int playerLevel = player.getLevel();
        String playerEnvironment = Environment.getEnvironment(player);
        String enemyName = Environment.getRandomEnemy(Environment.environmentMobList.get(playerEnvironment));
        EntityClass.Classes enemyClass = EntityClass.Classes.getClass(Environment.enemyClassList.get(enemyName));
        int enemyHealth = 1 + WMath.randInt(4) * playerLevel;
        int enemyArmor = WMath.clamp(1 * WMath.randInt(2) * playerLevel, 0, 20);
        String enemyType = Environment.getEnemyType(enemyName);
        String weakType = Environment.getWeakType(enemyName);
        System.out.println(enemyName + " has " + enemyHealth + " health!");
        Entity.getEntityList().add(new Enemy(enemyHealth, enemyArmor, generateWeapon(playerLevel, enemyType), playerLevel, playerLevel, weakType, enemyType, enemyClass, enemyName, playerEnvironment));
        System.out.println("Fight Generation Complete!");
        new FightProcesses();
    }

    public Weapon generateWeapon(int level, String type)
    {
        Weapon generatedWeapon = Weapons.getWeapon(level, type);
        if(generatedWeapon == null)
        {
            generatedWeapon = Weapons.getWeapon(level);
        }
        return generatedWeapon;
    }
}
