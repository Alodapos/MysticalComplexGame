package MysticalComplexGame.Commands;

import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;

import java.util.Map;

public class InventoryCommand extends ICommandVerbSolo
{
    private final String emptyInventory;

    public InventoryCommand()
    {
        key = "inventory";
        emptyInventory = "You have no items with you!";
    }

    @Override
    public void executeCommand(Player player)
    {
        if (player.getInventory().isEmpty())
            GameEngine.textOutput(emptyInventory);
        else
        {
            GameEngine.textOutput("Your inventory:");
            for (Map.Entry<String, IItem> item: player.getInventory().entrySet())
                GameEngine.textOutput(item.getValue().getInventoryDescription());
        }
    }
}
