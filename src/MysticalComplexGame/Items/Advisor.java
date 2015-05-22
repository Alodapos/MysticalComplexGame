package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Advisor extends IItem implements AttackableItem
{
    public Advisor()
    {
        pickable = false;
        name = "advisor";
        description = "He is significantly shorter than <name of tall man> and wears neat and elegant clothes making him very prestigious.\n" +
                "He holds a small case in his hands. His name is <name of short man>. He tells you that he is the mayor's advisor.";

    }

    @Override
    public void attack(Player player)
    {

    }
}
