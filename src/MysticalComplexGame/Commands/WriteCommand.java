package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.WritableItem;
import MysticalComplexGame.Player;

public class WriteCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;

    public WriteCommand()
    {
        key = "write";
        invalidArgument = "This is not something that you can write on";
        itemMissing = "You don't see or have such a thing.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getInventory().containsValue(item)) GameEngine.textOutput(itemMissing);
        else if (!(item instanceof WritableItem)) GameEngine.textOutput(invalidArgument);
        else
        {
            WritableItem toWrite = (WritableItem)item;
            toWrite.write();
        }
    }
}
