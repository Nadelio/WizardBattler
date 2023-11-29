package Game;

import Game.Player;
import Game.Enemy;
import Game.Process;
import java.util.*;

public class FightProcesses
{    
    private static int turn;
    public static Turn currentTurn;

    public FightProcesses()
    {
        FightProcesses.turn = 0;
        ArrayList<Player> playerList = Player.getPlayerList();
        Player firstPlayer = playerList.get(0);
        FightProcesses.currentTurn = new Turn(firstPlayer, 0, "Player");
    }

    public static Player getTarget()
    {
        ArrayList<Player> playerList = Player.getPlayerList();
        Random random = new Random();
        int rand = random.nextInt(0, playerList.length + 1);

        return playerList[rand];
    }

    public static int attackRoll(int rollRange)
    {
        Random random = new Random();
        int attackRoll = random.nextInt(0, rollRange);
        return attackRoll;
    }

    public static void nextTurn()
    {
        String lastActiveMember = getLastTurn();
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

    public static String getLastTurn()
    {
        Turn lastTurnData = getTurnData(turn - 1);
        String lastTurnMember = lastTurnData.getTurnMember();
        return lastTurnMember;
    }

    public static Turn updateTurnData()
    {
        FightProcesses.currentTurn.turnCount += 1;
        FightProcesses.currentTurn.member = nextTurnMember(FightProcesses.currentTurn.member);
        FightProcesses.currentTurn.memberInPLay = nextMemberInPlay(FightProcesses.currentTurn.memberInPlay);
    }

    public static String nextTurnMember(String member)
    {
        ArrayList<Entity> entityList = Entity.getEntityList();
        return entityList.get(turn + 1).toString();
    }
}
