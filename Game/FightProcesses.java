package Game;

import java.util.*;

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

    private static Entity currentEntity;

    public FightProcesses()
    {
        turnIterateNumber = 0;
        playerIndex = 0;
        enemyIndex = 0;
        turnMaxIterateNumber = Entity.getEntityList().size() - 1;
        turnCount = 0;
        ArrayList<Player> playerList = Player.getPlayerList();
        Player firstPlayer = playerList.get(0);
        currentEntity = firstPlayer;
        FightProcesses.currentTurn = new Turn(firstPlayer, 0, "Player");
        turnList.add(currentTurn);
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
        Random random = new Random();
        int attackRoll = random.nextInt(0, rollRange);
        return attackRoll;
    }

    public static void nextTurn()
    {
        for(Entity entity : Entity.getEntityList())
        {
            if(entity.getHealth() <= 0)
            {
                entity.setDead();
                if(entity instanceof Player)
                {
                    endFight();
                }
                Entity.getEntityList().remove(entity);
            }
        }
        if(currentTurn.getMemberInPlay().getDodged()){currentTurn.getMemberInPlay().setDodged();}
        if(turnIterateNumber >= turnMaxIterateNumber){turnIterateNumber = 0;}
        currentTurn = updateTurnData();
        currentEntity = Entity.getEntityList().get(turnIterateNumber + 1);
        turnCount++;
        turnIterateNumber++;
        if(currentEntity instanceof Player){enemyIndex++; if(enemyIndex > Enemy.getEnemyList().size() - 1){enemyIndex = 0;}}
        else{playerIndex++; if(playerIndex > Player.getPlayerList().size() - 1){playerIndex = 0;}}
        currentEntity.playTurn();
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

    public static void endFight()
    {
        System.out.println(Entity.getEntityList().get(turnIterateNumber).getName() + " died! Ending fight...");
    }

    public static Turn getTurnData(int turnListIndex){return turnList.get(turnListIndex);}
    public static int getTurnCount(){return turnCount;}
    public static int getTurnIterateNumber(){return turnIterateNumber;}
}
