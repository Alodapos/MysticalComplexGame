package MysticalComplexGame.Commands;

import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.ReadableItem;

import java.util.ArrayList;
import java.util.List;


public class ReadCommand extends ICommandVerbWithItem
{
    private final String itemMissing;
    private final String invalidArgument;

    public ReadCommand()
    {
        key = "read";
        invalidArgument = "This is not something that you can read...";
        itemMissing = "You don't see or have such a thing.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {

        List<IItem> localItems = new ArrayList<>();
        localItems.addAll(player.getInventory().values());
        localItems.addAll(player.getLocation().getItems().values());
        if (!localItems.contains(item)) GameEngine.textOutput(itemMissing);
        else if (!(item instanceof ReadableItem)) GameEngine.textOutput(invalidArgument);
        else
        {
            ReadableItem toRead = (ReadableItem)item;
            toRead.read();
        }
    }
}
