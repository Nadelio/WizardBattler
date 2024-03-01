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
        
        generateEnemy();

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

    public void generateEnemy()
    {
        System.out.println("Necessary Player Data Collected");
        System.out.println("Generating Enemy...");
        String enemyName = Environment.getRandomEnemy(Environment.environmentMobList.get(playerEnvironment));
        EntityClass.Classes enemyClass = EntityClass.Classes.getClass(Environment.enemyClassList.get(enemyName));
        int enemyHealth = (1 + WMath.randInt(4)) * playerLevel;
        int enemyArmor = WMath.clamp(1 * WMath.randInt(2) * playerLevel, 0, 20);
        String enemyType = Environment.getEnemyType(enemyName);
        String weakType = Environment.getWeakType(enemyName);
        Weapon enemyWeapon = generateWeapon(playerLevel, "NONE");
        new Enemy(enemyHealth, enemyArmor, enemyWeapon, 1, 20, weakType, enemyType, enemyClass, enemyName, playerEnvironment);
        System.out.println("Enemy fully generated");
    }
}
