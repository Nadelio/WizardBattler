package Game;

import java.util.*;

import Events.TurnPlayedEvent;
import WMath.WMath;

public class FightProcesses
{    
    private static int turnCount;
    private static int turnIterateNumber;
    private static int turnMaxIterateNumber;
    private static int playerIndex;
    private static int enemyIndex;
    public static Turn currentTurn;
    public static ArrayList<Turn> turnList = new ArrayList<Turn>();
    public static boolean turnUpdate;
    public static boolean fightActive;

    private static Entity currentEntity;

    public FightProcesses()
    {
        System.out.println("Someone got McMad!\nFight started!"); // remove in future
        fightActive = true;
        turnIterateNumber = 0;
        playerIndex = 0;
        enemyIndex = 0;
        turnMaxIterateNumber = Environment.entityList.size();
        turnCount = 0;
        ArrayList<Player> playerList = Environment.playerList;
        Player firstPlayer = playerList.get(0);
        currentEntity = firstPlayer;
        FightProcesses.currentTurn = new Turn(firstPlayer, 0, firstPlayer.getName());
        turnList.add(currentTurn);
        new TurnPlayedEvent().event();
        for(Entity e : Environment.entityList){System.out.println("| " + e.getName() + "'s health is: " + e.getHealth() + " and armor is: " + e.getArmor() + " |");}
        firstPlayer.playTurn();
    }

    public static Player getPlayerTarget()
    {
        ArrayList<Player> playerList = Environment.playerList;
        Random random = new Random();
        int rand = random.nextInt(0, playerList.size());

        return playerList.get(rand);
    }

    public static int attackRoll(int rollRange)
    {
        return WMath.randInt(rollRange);
    }

    public static void nextTurn()
    {
        if(endFightCheck())
        {
            turnIterateNumber++;
            if(turnIterateNumber >= turnMaxIterateNumber){turnIterateNumber = 0;}
            currentTurn = updateTurnData();
            turnCount++;
            currentEntity = Environment.entityList.get(turnIterateNumber);
            if(currentEntity instanceof Player){enemyIndex++; if(enemyIndex > Environment.enemyList.size() - 1){enemyIndex = 0;}}
            else{playerIndex++; if(playerIndex > Environment.playerList.size() - 1){playerIndex = 0;}}
            System.out.println("-----------------------------------------------------");
            new TurnPlayedEvent().event();
            for(Entity e : Environment.entityList){System.out.println("| " + e.getName() + "'s health is: " + e.getHealth() + " |");}
            currentEntity.playTurn();
        }
    }

    public static Entity getCurrentMemberInPlay()
    {
        return currentEntity;
    }

    public static Player getCurrentPlayer()
    {
        ArrayList<Player> playerList = Environment.playerList;
        return playerList.get(playerIndex);
    }

    public static Enemy getCurrentEnemy()
    {
        ArrayList<Enemy> enemyList = Environment.enemyList;
        return enemyList.get(enemyIndex);
    }

    public static String getLastTurnMember()
    {
        Turn lastTurnData = getTurnData(turnCount - 1);
        String lastTurnMember = lastTurnData.getMember();
        return lastTurnMember;
    }

    public static Turn updateTurnData()
    {
        turnUpdate = true;
        try {Thread.sleep(50);} catch (InterruptedException e){}
        turnUpdate = false;

        int currentTurnCount = currentTurn.getTurnCount(); 
        currentTurnCount += 1;

        String currentTurnMember = nextTurnMember();

        Entity curerntTurnMemberInPlay = nextMemberInPlay();

        Turn NEWTURN = new Turn(curerntTurnMemberInPlay, currentTurnCount, currentTurnMember);
        turnList.add(NEWTURN);

        return NEWTURN;
    }

    public static String nextTurnMember()
    {
        return Environment.entityList.get(turnIterateNumber).toString();
    }

    public static Entity nextMemberInPlay()
    {
        return Environment.entityList.get(turnIterateNumber);
    }

    public static boolean endFightCheck()
    {
        ArrayList<Entity> removalList = new ArrayList<Entity>();
        for(Entity entity : Environment.entityList)
        {
            if(entity.getHealth() <= 0)
            {
                entity.setDead();
                if(entity instanceof Player)
                {
                    return endFight(true);
                }
                else{removalList.add(entity);}
            }
        }

        for(Entity e : removalList)
        {
            if(Environment.entityList.contains(e))
            {
                Environment.entityList.remove(e);
            }
        }

        boolean enemiesLeft = false;

        for(Entity entity : Environment.entityList)
        {
            if(entity instanceof Enemy)
            {
                enemiesLeft = true;
            }
        }

        if(enemiesLeft == false){return endFight(false);}
        return true;
    }

    static int endFightRunCount = 0;

    public static boolean endFight(boolean playerDied) // credit to PogMaster9001 for part of the bug fix for this!!
    {
        if(fightActive)
        {
            if(!playerDied && endFightRunCount == 0)
            {
                System.out.println("All enemies eliminated! Ending fight...");
                for(Player p : Environment.playerList){p.setFirstRun(); LevelUp.addXP(p);}
                endFightRunCount++;
            }
            else if(playerDied && endFightRunCount == 0)
            {
                if(Environment.playerList.size() > 1)
                {
                    int deadcount = 0;
                    for(Player p : Environment.playerList)
                    {
                        if(p.getDead())
                        {
                            p.setFirstRun();
                            deadcount++;
                        }
                    }
                    if(deadcount == Environment.playerList.size())
                    {
                        System.out.println("All players are dead! Ending fight...");
                        endFightRunCount++;
                    }
                }
                else if(Environment.playerList.size() == 1)
                {
                    System.out.println(Environment.entityList.get(turnIterateNumber - 1) + " died! Ending fight...");
                    endFightRunCount++;
                }
            }
            turnMaxIterateNumber = Environment.entityList.size() - 1;
            return false;
        }
        return true;
    }

    public static Turn getTurnData(int turnListIndex){return turnList.get(turnListIndex);}
    public static int getTurnCount(){return turnCount;}
    public static int getTurnIterateNumber(){return turnIterateNumber;}
}
