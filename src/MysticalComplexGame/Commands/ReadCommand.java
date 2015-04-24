package MysticalComplexGame.Commands;

import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.ReadableItem;

import java.util.ArrayList;
import java.util.List;


public class ReadCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;

    public ReadCommand()
    {
        key = "read";
        invalidArgument = "This is not something that you can read...";
        itemMissing = "You don't see or have such a thing.";
    }

    @Override
    public void executeCommand(IItem item)
    {

        List<IItem> localItems = new ArrayList<IItem>();
        localItems.addAll(Player.getInventory().values());
        localItems.addAll(Player.getLocation().getItems().values());

        if (!localItems.contains(item)) GameEngine.textOutput(itemMissing);
        else if (!(item instanceof ReadableItem)) GameEngine.textOutput(invalidArgument);
        else
        {
            ReadableItem toRead = (ReadableItem)item;
            toRead.read();
        }
    }
}
