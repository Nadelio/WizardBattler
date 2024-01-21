package Game;

import Classes.EntityClass;
import WMath.WMath;
import Weapons.Weapon;
import Weapons.Weapons;

public class GenerateFight
{
    public Player player;
    public int playerLevel;
    public String playerEnvironment;

    public GenerateFight()
    {
        System.out.println("Generating Fight...");
        player = Main.getPlayer();
        playerLevel = player.getLevel();
        playerEnvironment = Environment.getEnvironment(player);
        
        Enemy enemy = generateEnemy();

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

    public Enemy generateEnemy()
    {
        System.out.println("Necessary Player Data Collected");
        String enemyName = Environment.getRandomEnemy(Environment.environmentMobList.get(playerEnvironment));
        System.out.println("Enemy name generated");
        EntityClass.Classes enemyClass = EntityClass.Classes.getClass(Environment.enemyClassList.get(enemyName));
        System.out.println("Enemy class generated");
        int enemyHealth = (1 + WMath.randInt(4)) * playerLevel;
        System.out.println("Enemy health generated");
        int enemyArmor = WMath.clamp(1 * WMath.randInt(2) * playerLevel, 0, 20);
        System.out.println("Enemy armor generated");
        String enemyType = Environment.getEnemyType(enemyName);
        System.out.println("Enemy type generated");
        String weakType = Environment.getWeakType(enemyName);
        System.out.println("Enemy weakness generated");
        Enemy enemy = new Enemy(enemyHealth, enemyArmor, generateWeapon(playerLevel, enemyType), playerLevel, playerLevel, weakType, enemyType, enemyClass, enemyName, playerEnvironment);
        System.out.println("Enemy fully generated");
        return enemy;
    }
}
