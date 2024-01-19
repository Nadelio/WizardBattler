package WMath;

import java.util.Random;

public class WMath
{
    public static int randInt(int min, int max){return (int) ((Math.random() * (max - min)) + min);}
    public static int randInt(int max){return new Random().nextInt(max);}

    public static int clamp(int value, int min, int max)
    {
        if(value <= min)
        {
            return min;
        }
        else if(value >= max)
        {
            return max;
        }
        else
        {
            return value;
        }
    }
}
