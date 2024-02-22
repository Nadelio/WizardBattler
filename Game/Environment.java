package Game;

import java.util.ArrayList;
import java.util.HashMap;

import WMath.WMath;

import Classes.*;
import Fighter.*;
import Wizard.*;
import Archer.*;
import Paladin.*;

public class Environment
{
    public static HashMap<String, ArrayList<String>> environmentMobList = new HashMap<String, ArrayList<String>>();
    public static HashMap<String, Integer> enemyClassList = new HashMap<String, Integer>();
    public static HashMap<String, String[]> enemyTypes = new HashMap<String, String[]>();
    public static HashMap<EntityClass.Classes, Actions> classActions = new HashMap<EntityClass.Classes, Actions>();
    public static HashMap<EntityClass.Classes, Classes.Class> classes = new HashMap<EntityClass.Classes, Classes.Class>();
    public static ArrayList<Entity> entityList = new ArrayList<Entity>();
    public static ArrayList<Enemy> enemyList = new ArrayList<Enemy>();
    public static ArrayList<Player> playerList = new ArrayList<Player>();

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

        classActions.put(EntityClass.Classes.Fighter, new FighterActions(new FighterAction[]{new TriplePunch(), new Dodge(), new StrongPunch()}));
        classActions.put(EntityClass.Classes.Wizard, new Spells(new Spell[]{new Fireball(), new Recovery(), new Resistance()}));
        classActions.put(EntityClass.Classes.Archer, new ArcherActions(new ArcherAction[]{new FireArrow(), new SmokeArrow(), new StormArrow()}));
        classActions.put(EntityClass.Classes.Paladin, new PaladinActions(new PaladinAction[]{new HealingPrayer(), new DownwardSlash(), new ShieldBlock()}));
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

    public static Enemy getEnemyFromList(String entityname)
    {
        for(Enemy enemy : enemyList){if(enemy.getName().equals(entityname)){return enemy;}}
        return null;
    }
}