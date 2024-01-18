package Classes;

import java.util.ArrayList;

public class EntityClass
{
    public static ArrayList<String> classList = new ArrayList<String>(){{add("Fighter"); add("Wizard"); add("Archer"); add("Paladin");}};

    public enum Classes
    {
        Fighter(0),
        Wizard(1),
        Archer(2),
        Paladin(3);

        private int classIndex;

        private Classes(int index){this.classIndex = index;}

        public static Classes getClass(int index)
        {
            for(Classes c : Classes.values())
            {
                if(c.classIndex == index){return c;}
            }
            throw new IllegalArgumentException("Index does not represent a existing class, please retry");
        }

    } // add more classes in the future?
}
// Fighter: Done
// Wizard: Done
// Archer: Done
// Paladin: Done