package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Hodor extends IItem implements AttackableItem
{
    private final boolean alive;

    public Hodor()
    {
        alive = true;
        pickable = false;
        name = "hodor";
        description = "The road is currently guarded by a husky man. \"Hodor!\", he shouts.";

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
