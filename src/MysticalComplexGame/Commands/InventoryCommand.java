package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.GameContent;
import MysticalComplexGame.Items.IItem;
import java.util.Map;

public class InventoryCommand implements ICommand
{

    private String name;
    private String invalidArgument;
    private String emptyInventory;

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
    public void executeCommand(Character character, String argument, GameContent content)
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
