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
        invalidArgument = "This is not something that you can "+key+".";
        itemMissing = "You don't see such a thing.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getLocation().getItems().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof LightEmitter))
            GameEngine.textOutput(invalidArgument);
        else
            ((LightEmitter)item).light(player);
    }
}
