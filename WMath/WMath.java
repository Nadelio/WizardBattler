package WMath;

public class WMath
{
    public static int randInt(int min, int max)
    {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
