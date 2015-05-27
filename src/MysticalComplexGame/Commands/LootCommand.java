package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.BreakableItem;
import MysticalComplexGame.Items.ContainerItem;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.LootableItem;
import MysticalComplexGame.Player;

public class LootCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;
    private String alreadyLooted;
    private String isEmpty;

    public LootCommand()
    {
        key = "loot";
        invalidArgument = "This is not something that you can loot...";
        itemMissing = "You can't see such a thing.";
        alreadyLooted = "The vase is broken and all it's loot lie on the altar.";
        isEmpty = "It is empty.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {

        if (!player.getLocation().getItems().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof ContainerItem))
            GameEngine.textOutput(invalidArgument);
        else if(((LootableItem)item).isLooted())
            GameEngine.textOutput(isEmpty);
        else if(((BreakableItem)item).isBroken() || ((LootableItem)item).isEmpty())
            GameEngine.textOutput(alreadyLooted);
        else
            ((ContainerItem)item).pickLoot(player);
    }
}
