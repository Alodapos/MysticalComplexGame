package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.AttachableItem;
import MysticalComplexGame.Player;

public class AttachCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;
    private String alreadyAttached;
    public AttachCommand()
    {
        itemMissing = "You do not have this item with you.";
        invalidArgument = "This is not something that you can " + key + ".";
        key = "attach";
        alreadyAttached = "This is already attached.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getInventory().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof AttachableItem))
            GameEngine.textOutput(invalidArgument);
        else if(((AttachableItem) item).isAttached())
            GameEngine.textOutput(alreadyAttached);
        else
        {
            ((AttachableItem)item).attach(player);
        }
    }
}
