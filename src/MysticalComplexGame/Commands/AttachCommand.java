package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.AttachableItem;
import MysticalComplexGame.Player;

public class AttachCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;
    public AttachCommand()
    {
        itemMissing = "You do not have this item with you.";
        invalidArgument = "This is not something that you can " + key + ".";
        key = "attach";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getInventory().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof AttachableItem))
            GameEngine.textOutput(invalidArgument);
        else
        {
            ((AttachableItem)item).attach(player);
        }
    }
}
