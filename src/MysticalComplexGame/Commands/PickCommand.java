package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.Scene;
import java.util.Map;

public class PickCommand implements ICommand
{

    String missingArgument;
    String invalidArgument;
    String actionFailed;
    String skippedWord;
    String name;
    public PickCommand()
    {
        missingArgument = "You have to specify what do you want to pick.";
        invalidArgument = "I can't see such a thing.";
        actionFailed = "This is not something I can pick!";
        skippedWord = "up ";
        name = "pick";

    }
    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void executeCommand(Character character, String argument, Map<String, Scene> scenes)
    {
        argument = trimArgument(argument);
        if (argument.equals("")) System.out.println(missingArgument);
        else if (!character.getLocation().getItems().containsKey(argument)) System.out.println(invalidArgument);
        else if (!character.getLocation().getItems().get(argument).getTags().contains(this.name)) System.out.println(actionFailed);
        else
        {
            character.addToInventory(character.getLocation().getItems().get(argument));
            System.out.println("Picked "+ argument +".");
            character.getLocation().removeItem(argument);
        }
    }
    private String trimArgument(String argument)
    {
        if (argument.startsWith(skippedWord)) argument = argument.replaceFirst("up +","");
        return argument;
    }
}
