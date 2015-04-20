package MysticalComplexGame.Commands;

import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;

import java.util.Map;

public class InventoryCommand extends ICommandVerbAlone
{
    private String emptyInventory;

    public InventoryCommand()
    {
        key = "inventory";
        emptyInventory = "You have no items with you!";
    }

    @Override
    public void executeCommand()
    {
        if (Player.getInventory().isEmpty()) GameEngine.textOutput(emptyInventory);
        else
        {
            GameEngine.textOutput("Your inventory:");
            for (Map.Entry<String, IItem> item: Player.getInventory().entrySet()) GameEngine.textOutput(item.getValue().getInventoryDescription());
        }
    }
}
