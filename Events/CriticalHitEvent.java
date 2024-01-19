package Events;

import Game.FightProcesses;

public class CriticalHitEvent extends Events
{
        private String eventName = "CriticalHit";

        @Override
        public void event()
        {
            System.out.println("Critical hit! Double damage dealt with " + FightProcesses.getTurnData(FightProcesses.getTurnCount()).getMemberInPlay().getWeapon() + "!");
        }
}
