package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;

public class PickCommand implements ICommand
{

    private final String name= "pick";
    private final String missingArgument = "You have to specify what do you want to pick";
    private final String argumentNotFound = "I can't see that thing.";
    private final String actionFailed = "This is not something that i can pick!";

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void executeCommand(ICharacter character, String argument, ArrayList<IScene> scenes)
    {
        argument = argument.trim();
        ArrayList<IItem> itemsList = character.getCurrentLocation().getItemsList();
        ArrayList<String> itemNames = new ArrayList<String>();
        for (IItem item: itemsList) itemNames.add(item.getName());
        int itemIndex = itemNames.indexOf(argument);

        if (argument.equals("")) System.out.println(missingArgument);
        else if (itemIndex == -1) System.out.println(argumentNotFound);
        else if (itemsList.get(itemIndex).isPickable())
        {
            character.addToInventory(itemsList.get(itemIndex));
            System.out.println("Picked "+ argument +".");
            character.getCurrentLocation().removeItem(itemIndex);
        }
        else System.out.println(actionFailed);


    }
}
