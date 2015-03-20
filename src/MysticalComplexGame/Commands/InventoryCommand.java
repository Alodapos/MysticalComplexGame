package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;

public class InventoryCommand implements ICommand
{

    @Override
    public String getName()
    {
        return "inventory";
    }

    @Override
    public void executeCommand(ICharacter character, String argument, ArrayList<IScene> scenes)
    {
        String invalidArgument = "I understood as far as you wanted to look at your inventory.";
        String emptyInventory = "You have no items!";
        argument = argument.trim();

        if (!argument.equals("")) System.out.println(invalidArgument);
        else if (character.getInventory().isEmpty()) System.out.println(emptyInventory);
        else
        {
            System.out.printf("Your inventory:\n");
            for (IItem item: character.getInventory()) System.out.println(item.getInventoryDescription());
        }
    }
}
