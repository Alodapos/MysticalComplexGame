package MysticalComplexGame.Items;

//import MysticalComplexGame.Player;

public class Hodor extends IItem //implements AttackableItem
{
    private boolean alive;

    public Hodor()
    {
        alive = true;
        pickable = false;
        name = "hodor";
        description = "The road is currently guarded by a husky man. \"Hodor!\", he shouts.";

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
