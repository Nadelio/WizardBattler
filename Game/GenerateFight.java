package Game;

import Classes.EntityClass;
import Weapons.Weapon;
import Weapons.Weapons;

public class GenerateFight
{
    public GenerateFight()
    {
        Player player = Main.getPlayer();
        int playerLevel = player.getLevel();
        Entity.getEntityList().add(new Enemy(10 * playerLevel, 0, generateWeapon(playerLevel, "NONE"), playerLevel, 1, "NONE", "NONE", EntityClass.Classes.Fighter, "test_enemy"));
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
