package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.LootableItem;
import MysticalComplexGame.Player;

public class LootCommand extends ICommandVerbWithItem
{
    private final String itemMissing;
    private final String invalidArgument;
    private final String alreadyLooted;

    public LootCommand()
    {
        key = "loot";
        invalidArgument = "This is not something that you can loot...";
        itemMissing = "You can't see such a thing.";
        alreadyLooted = "It is empty.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {

        if (!player.getLocation().getItems().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof LootableItem))
            GameEngine.textOutput(invalidArgument);
        else if(((LootableItem)item).isEmpty())
            GameEngine.textOutput(alreadyLooted);
        else
            ((LootableItem)item).loot(player);
    }
}
