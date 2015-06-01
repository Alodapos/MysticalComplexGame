package MysticalComplexGame.Items;

//import MysticalComplexGame.Player;

public class LuwinMaester extends IItem //implements AttackableItem
{
    private boolean alive;

    public LuwinMaester()
    {
        alive = true;
        pickable = false;
        name = "advisor";
        description = "He is significantly shorter than General Cornelius and wears neat and elegant clothes making him very prestigious.\n" +
                "He holds a small case in his hands. His name is Luwin Maester. He tells you that he is the Mayor's advisor.";

    }

    /*@Override
    public void attack(Player player)
    {
        alive = false;
        description = "The LuwinMaester lies dead on the floor.";
        //TODO drop loot & text on death
    }

    @Override
    public boolean isAlive()
    {
        return alive;
    }*/
}
