package Game;

import java.util.*;

public class FightProcesses
{    
    private static int turnCount;
    private static int turnIterateNumber;
    private static int turnMaxIterateNumber;
    public static Turn currentTurn;
    public static ArrayList<Turn> turnList;
    public static boolean turnUpdate;

    public FightProcesses()
    {
        turnIterateNumber = 0;
        turnMaxIterateNumber = Entity.getEntityList().size() - 1;
        turnCount = 0;
        ArrayList<Player> playerList = Player.getPlayerList();
        Player firstPlayer = playerList.get(0);
        FightProcesses.currentTurn = new Turn(firstPlayer, 0, "Player");
        turnList.add(currentTurn);
        firstPlayer.playTurn();
    }

    public static Player getTarget()
    {
        ArrayList<Player> playerList = Player.getPlayerList();
        Random random = new Random();
        int rand = random.nextInt(0, playerList.size() + 1);

        return playerList.get(rand);
    }

    public static int attackRoll(int rollRange)
    {
        Random random = new Random();
        int attackRoll = random.nextInt(0, rollRange);
        return attackRoll;
    }

    public static void nextTurn()
    {
        if(currentTurn.getMemberInPlay().getDodged()){currentTurn.getMemberInPlay().setDodged();}
        if(turnIterateNumber >= turnMaxIterateNumber){turnIterateNumber = 0;}
        currentTurn = updateTurnData();
        Entity currentEntity = Entity.getEntityList().get(turnIterateNumber + 1);
        turnCount++;
        turnIterateNumber++;
        currentEntity.playTurn();
    }

    public static Player getCurrentPlayer()
    {
        ArrayList<Player> playerList = Player.getPlayerList();
        return playerList.get((int) turnIterateNumber / 2);
    }

    public static Enemy getCurrentEnemy()
    {
        ArrayList<Enemy> enemyList = Enemy.getEnemyList();
        return enemyList.get((int) turnIterateNumber / 2);
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

    public static Turn getTurnData(int turnListIndex){return turnList.get(turnListIndex);}
    public static int getTurnCount(){return turnCount;}
}
