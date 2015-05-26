package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.LightEmitter;
import MysticalComplexGame.Player;


public class QuenchCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;

    public QuenchCommand()
    {
        key = "quench";
        invalidArgument = "This is not something that I can quench.";
        itemMissing = "You don't have or see such a thing.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getLocation().getItems().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof LightEmitter))
            GameEngine.textOutput(invalidArgument);
        else
            ((LightEmitter)item).quench();
    }
}
