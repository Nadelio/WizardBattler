package Game;

import java.util.ArrayList;
import java.util.HashMap;

import Classes.*;
import WMath.WMath;

public class Environment
{
    public static HashMap<String, ArrayList<String>> environmentMobList = new HashMap<String, ArrayList<String>>();
    public static HashMap<String, Integer> enemyClassList = new HashMap<String, Integer>();
    public static HashMap<String, String[]> enemyTypes = new HashMap<String, String[]>();
    public static HashMap<EntityClass.Classes, Actions> classActions = new HashMap<EntityClass.Classes, Actions>();
    public static HashMap<EntityClass.Classes, Classes.Class> classes = new HashMap<EntityClass.Classes, Classes.Class>();

    public Environment()
    {
        environmentMobList.put("Plains", new ArrayList<String>(){{add("wolf"); add("bandit"); add("hog");}});
        environmentMobList.put("Forest", new ArrayList<String>(){{add("wolf"); add("bandit"); add("wizard");}});
        environmentMobList.put("Ruins", new ArrayList<String>(){{add("zombie"); add("skeleton"); add("wizard");}});
        environmentMobList.put("Catacombs", new ArrayList<String>(){{add("zombie"); add("bandit"); add("skeleton");}});
        environmentMobList.put("Town", new ArrayList<String>(){{add("bandit"); add("knight");}});
        environmentMobList.put("City", new ArrayList<String>(){{add("bandit"); add("wizard"); add("knight");}});

        enemyClassList.put("wolf", 0);
        enemyClassList.put("bandit", 0);
        enemyClassList.put("hog", 0);
        enemyClassList.put("wizard", 1);
        enemyClassList.put("zombie", 0);
        enemyClassList.put("skeleton", 0);
        enemyClassList.put("knight", 3);

        enemyTypes.put("wolf", new String[]{"NONE", "NONE"});
        enemyTypes.put("bandit", new String[]{"NONE", "NONE"});
        enemyTypes.put("hog", new String[]{"NONE", "NONE"});
        enemyTypes.put("wizard", new String[]{"MAGIC", "CURSED"});
        enemyTypes.put("zombie", new String[]{"CURSED", "HOLY"});
        enemyTypes.put("skeleton", new String[]{"CURSED", "HOLY"});
        enemyTypes.put("knight", new String[]{"HOLY", "CURSED"});

        classActions.put(EntityClass.Classes.Fighter, Fighter.getActions(1));
        classActions.put(EntityClass.Classes.Wizard, Wizard.getActions(1));
        classActions.put(EntityClass.Classes.Archer, Archer.getActions(1));
        classActions.put(EntityClass.Classes.Paladin, Paladin.getActions(1));
    }

    public static String getEnvironment(Player player)
    {
        return player.getCurrentEnvironment();
    }

    public static String getRandomEnemy(ArrayList<String> environmentMobs)
    {
        return environmentMobs.get(WMath.randInt(environmentMobs.size()));
    }

    public static String getEnemyType(String enemyName)
    {
        return enemyTypes.get(enemyName)[0];
    }

    public static String getWeakType(String enemyName)
    {
        return enemyTypes.get(enemyName)[1];
    }

    public static Actions getActions(EntityClass.Classes Class)
    {
        return classActions.get(Class);
    }
}

// Plains, Forest, Ruins, Catacombs, Town, City
