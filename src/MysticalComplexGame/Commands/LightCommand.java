package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.LightEmitter;
import MysticalComplexGame.Player;


public class LightCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;

    public LightCommand()
    {
        key = "light";
        invalidArgument = "This is not something that i can light";
        itemMissing = "You don't have something like this with you.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getInventory().containsValue(item)) GameEngine.textOutput(itemMissing);
        else if (!(item instanceof LightEmitter)) GameEngine.textOutput(invalidArgument);
        else
        {
            LightEmitter itemArgument = (LightEmitter) item;
            itemArgument.light(player, item);
        }
    }
}
