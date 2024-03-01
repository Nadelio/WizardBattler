package Game;

import Events.LevelUpEvent;
import WMath.WMath;

public class LevelUp
{
    public static void addXP(Player player)
    {
        double newXP = 10 * Math.pow(2, player.getLevel() - 1);
        int newerXP = (player.getCurrentXP() + (int) Math.round(newXP));
        levelUP(player, newerXP);
    }

    private static void levelUP(Player player, int XP)
    {
        int levelUpThreshold = 10 * ((int) Math.round(Math.pow(2, player.getLevel() + 1)));
        if(XP > levelUpThreshold)
        {
            player.setLevel(player.getLevel() + 1);
            player.setCurrentXP(0);
            doLevelUp(player);
            new LevelUpEvent().event(player);
        }
        else
        {
            player.setCurrentXP(XP);
        }
    }

    private static void doLevelUp(Player player)
    {
        int level = player.getLevel();

        player.setHealth(level * WMath.randInt(1, 4) + 2);
        player.setArmor(WMath.clamp(level * WMath.randInt(1, 4), player.getArmor(), 20));
        player.setTotalHealth(player.getHealth());
    }
}
