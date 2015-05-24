package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public class Advisor extends IItem implements AttackableItem
{
    private boolean alive;

    public Advisor()
    {
        alive = true;
        pickable = false;
        name = "advisor";
        description = "He is significantly shorter than <name of tall man> and wears neat and elegant clothes making him very prestigious.\n" +
                "He holds a small case in his hands. His name is <name of short man>. He tells you that he is the mayor's advisor.";

    }

    @Override
    public void attack(Player player)
    {
        alive = false;
        description = "The Advisor lies dead on the floor.";
        //TODO drop loot & text on death
    }

    @Override
    public boolean isAlive()
    {
        return alive;
    }
}
