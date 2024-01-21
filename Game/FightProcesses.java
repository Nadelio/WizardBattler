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
        System.out.println("Fight started!");
        fightActive = true;
        turnIterateNumber = 0;
        playerIndex = 0;
        enemyIndex = 0;
        turnMaxIterateNumber = Entity.getEntityList().size() - 1;
        turnCount = 0;
        ArrayList<Player> playerList = Player.getPlayerList();
        Player firstPlayer = playerList.get(0);
        currentEntity = firstPlayer;
        FightProcesses.currentTurn = new Turn(firstPlayer, 0, firstPlayer.getName());
        turnList.add(currentTurn);
        new TurnPlayedEvent().event();
        firstPlayer.playTurn();
    }

    public static Player getPlayerTarget()
    {
        ArrayList<Player> playerList = Player.getPlayerList();
        Random random = new Random();
        int rand = random.nextInt(0, playerList.size() + 1);

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
            if(currentTurn.getMemberInPlay().getDodged()){currentTurn.getMemberInPlay().setDodged();}
            turnIterateNumber++;
            if(turnIterateNumber >= turnMaxIterateNumber){turnIterateNumber = 0;}
            currentTurn = updateTurnData();
            turnCount++;
            currentEntity = Entity.getEntityList().get(turnIterateNumber);
            if(currentEntity instanceof Player){enemyIndex++; if(enemyIndex > Enemy.getEnemyList().size() - 1){enemyIndex = 0;}}
            else{playerIndex++; if(playerIndex > Player.getPlayerList().size() - 1){playerIndex = 0;}}
            System.out.println("-----------------------------------------------------");
            new TurnPlayedEvent().event();
            currentEntity.playTurn();
        }
    }

    public static Entity getCurrentMemberInPlay()
    {
        return currentEntity;
    }

    public static Player getCurrentPlayer()
    {
        ArrayList<Player> playerList = Player.getPlayerList();
        return playerList.get(playerIndex);
    }

    public static Enemy getCurrentEnemy()
    {
        ArrayList<Enemy> enemyList = Enemy.getEnemyList();
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
        return Entity.getEntityList().get(turnIterateNumber).toString();
    }

    public static Entity nextMemberInPlay()
    {
        return Entity.getEntityList().get(turnIterateNumber);
    }

    public static boolean endFightCheck()
    {
        ArrayList<Entity> removalList = new ArrayList<Entity>();
        for(Entity entity : Entity.getEntityList())
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
            if(Entity.getEntityList().contains(e))
            {
                Entity.getEntityList().remove(e);
            }
        }

        boolean enemiesLeft = false;

        for(Entity entity : Entity.getEntityList())
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
                endFightRunCount++;
            }
            else if(playerDied && endFightRunCount == 0)
            {
                System.out.println(Entity.getEntityList().get(turnIterateNumber) + " died! Ending fight...");
                endFightRunCount++;
            }
            turnMaxIterateNumber = Entity.getEntityList().size() - 1;
            return false;
        }
        return true;
    }

    public static Turn getTurnData(int turnListIndex){return turnList.get(turnListIndex);}
    public static int getTurnCount(){return turnCount;}
    public static int getTurnIterateNumber(){return turnIterateNumber;}
}
