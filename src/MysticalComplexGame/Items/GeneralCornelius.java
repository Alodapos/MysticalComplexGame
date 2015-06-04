package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class GeneralCornelius extends IItem implements AttackableItem
{
    private final boolean alive;

    public GeneralCornelius()
    {
        alive = true;
        pickable = false;
        name = "general cornelius";
        description = "But when you ask to know where the Mayor himself is, General Cornelius tells you that he's gone missing for a few days now.\n" +
                "\"But, maybe you could find him!\", the General exclaims. \"Here, take this token and present it to Hodor located at the village's eastern exit.\n" +
                "He doesn't say much but he'll know I sent you and will let you pass. Please, stranger, find the Mayor! We are doomed without him...\".\n" +
                "And so General Cornelius, bearing a much worrying look, opens the small case, that Luwin holds in his hands, and a silver token is revealed.";

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
