package Game;

import Game.Player;
import Game.Enemy;
import java.util.*;

public class FightProcesses
{    
    private static int turn;
    public static Turn currentTurn;
    public static ArrayList<Turn> turnList;

    public FightProcesses()
    {
        FightProcesses.turn = 0;
        ArrayList<Player> playerList = Player.getPlayerList();
        Player firstPlayer = playerList.get(0);
        FightProcesses.currentTurn = new Turn(firstPlayer, 0, "Player");
        turnList.add(currentTurn);
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
        String lastActiveMember = getLastTurnMember();
        if(lastActiveMember.equals("Enemy"))
        {
            Player currentPlayer = getCurrentPlayer();
            currentPlayer.playTurn();
            currentTurn = updateTurnData();
        }
    }

    public static Player getCurrentPlayer()
    {
        ArrayList<Player> playerList = Player.getPlayerList();
        return playerList.get((int)(turn/2));
    }

    public static Enemy getCurrentEnemy()
    {
        ArrayList<Enemy> enemyList = Enemy.getEnemyList();
        return enemyList.get((int)(turn/2));
    }

    public static String getLastTurnMember()
    {
        Turn lastTurnData = getTurnData(turn - 1);
        String lastTurnMember = lastTurnData.getMember();
        return lastTurnMember;
    }

    public static Turn updateTurnData()
    {
        int currentTurnCount = FightProcesses.currentTurn.getTurnCount(); 
        currentTurnCount += 1;

        String currentTurnMember = nextTurnMember();

        Entity curerntTurnMemberInPlay = nextMemberInPlay();

        Turn NEWTURN = new Turn(curerntTurnMemberInPlay, currentTurnCount, currentTurnMember);
        turnList.add(NEWTURN);

        return NEWTURN;
    }

    public static String nextTurnMember()
    {
        ArrayList<Entity> entityList = Entity.getEntityList();
        return entityList.get(turn + 1).toString();
    }

    public static Entity nextMemberInPlay()
    {
        ArrayList<Entity> entityList = Entity.getEntityList();
        return entityList.get(turn + 1);
    }

    public static Turn getTurnData(int turnListIndex)
    {
        return turnList.get(turnListIndex);
    }
}
