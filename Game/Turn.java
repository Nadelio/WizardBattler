package Game;

public class Turn
{
    private Entity memberInPlay;
    private int turnCount;
    private String member;

    public Turn(Entity memberInPlay, int turnCount, String member)
    {
        this.memberInPlay = memberInPlay;
        this.turnCount = turnCount;
        this.member = member;
    }

    public Entity getMemberInPlay()
    {
        return memberInPlay;
    }

    public int getTurnCount()
    {
        return turnCount;
    }

    public String getMember()
    {
        return member;
    }
}
