package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.Scene;
import java.util.Map;

public class DropCommand implements ICommand
{

    String missingArgument;
    String invalidArgument;
    String actionFailed;
    String name;
    public DropCommand()
    {
        missingArgument = "You have to specify what do you want to drop.";
        invalidArgument = "I do not have this item with me.";
        actionFailed = "I will not drop this, it's very important!";
        name = "drop";
    }
    @Override
    public String getName()
    {
        return name;
    }
    @Override
    public void executeCommand(Character character, String argument, Map<String, Scene> scenes)
    {
        if (argument.equals("")) System.out.println(missingArgument);
        else if (!character.getInventory().containsKey(argument)) System.out.println(invalidArgument);
        else if (!character.getInventory().get(argument).getTags().contains(this.name)) System.out.println(actionFailed);
        else
        {
            character.getLocation().addItem(character.getInventory().get(argument));
            System.out.println("Dropped "+ argument +".");
            character.removeFromInventory(argument);
        }
    }
}
