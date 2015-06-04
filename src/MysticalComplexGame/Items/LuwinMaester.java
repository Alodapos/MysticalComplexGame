package MysticalComplexGame.Items;

import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;

public class LuwinMaester extends IItem implements AttackableItem
{
    private final boolean alive;

    public LuwinMaester()
    {
        alive = true;
        pickable = false;
        name = "luwin maester";
        description = "He is significantly shorter than General Cornelius and wears neat and elegant clothes making him very prestigious.\n" +
                "He holds a small case in his hands. His name is Luwin Maester. He tells you that he is the Mayor's advisor.";

    }

    @Override
    public void attack(Player player)
    {
        GameEngine.textOutput("You should not attack the residents of the village.");
        //TODO attack
    }

    @Override
    public boolean isAlive()
    {
        return alive;
    }
}
