package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.BreakableItem;
import MysticalComplexGame.Player;

public class BreakCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;
    private String alreadyBroken;

    public BreakCommand()
    {
        key = "break";
        invalidArgument = "This is not something that you can break...";
        itemMissing = "You can't see such a thing.";
        alreadyBroken = "This is already broken.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {

        if (!player.getLocation().getItems().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof BreakableItem))
            GameEngine.textOutput(invalidArgument);
        else if(((BreakableItem)item).isBroken())
            GameEngine.textOutput(alreadyBroken);
        else
            ((BreakableItem)item).breakObject(player);
    }
}
