package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.BreakableItem;
import MysticalComplexGame.Items.ContainerItem;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Player;

public class LootCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;

    public LootCommand()
    {
        key = "loot";
        invalidArgument = "This is not something that you can loot...";
        itemMissing = "You can't see such a thing.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {

        if (!player.getLocation().getItems().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof ContainerItem))
            GameEngine.textOutput(invalidArgument);
        else if(item instanceof BreakableItem)
            ((ContainerItem)item).pickLoot(player);
        else
            ((ContainerItem)item).dropLoot(player);
    }
}
