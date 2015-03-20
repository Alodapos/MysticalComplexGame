package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;

public class DropCommand implements ICommand
{

    @Override
    public String getName()
    {
        return "drop";
    }

    @Override
    public void executeCommand(ICharacter character, String argument, ArrayList<IScene> scenes)
    {
        argument = argument.trim();
        ArrayList<IItem> itemsList = character.getInventory();
        ArrayList<String> itemNames = new ArrayList<String>();
        for (IItem item: itemsList) itemNames.add(item.getName());
        int itemIndex = itemNames.indexOf(argument);

        String missingArgument = "You have to specify what you want to drop.";
        String argumentNotFound = "I don't have this in my inventory.";
        String actionFailed = "You'd better not drop this.";
        if (argument.equals("")) System.out.println(missingArgument);
        else if (itemIndex == -1) System.out.println(argumentNotFound);
        else if (itemsList.get(itemIndex).isPickable())
        {
            character.getCurrentLocation().addItem(itemsList.get(itemIndex));
            System.out.println("Dropped "+ argument +".");
            character.removeFromInventory(itemsList.get(itemIndex));
        }
        else System.out.println(actionFailed);
    }
}
