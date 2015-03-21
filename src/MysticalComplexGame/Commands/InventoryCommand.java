package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scene;
import java.util.HashMap;
import java.util.Map;

public class InventoryCommand implements ICommand
{

    String name;
    String invalidArgument;
    String emptyInventory;

    public InventoryCommand()
    {
        name = "inventory";
        invalidArgument = "I understood as far as you wanted to take a look at your inventory";
        emptyInventory = "You have no items with you!";
    }
    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void executeCommand(Character character, String argument, Map<String, Scene> scenes)
    {
        if (!argument.equals("")) System.out.println(invalidArgument);
        else if (character.getInventory().isEmpty()) System.out.println(emptyInventory);
        else
        {
            System.out.println("Your inventory:");
            for (Map.Entry<String, IItem> item: character.getInventory().entrySet()) System.out.println(item.getValue().getInventoryDescription());
        }
    }
}
