package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.GameContent;

public class PickCommand implements ICommand
{

    private String missingArgument;
    private String invalidArgument;
    private String actionFailed;
    private String skippedWord;
    private String name;
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
    public void executeCommand(Character character, String argument, GameContent content)
    {
        argument = trimArgument(argument, skippedWord);
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
    private String trimArgument(String argument, String toTrim)
    {
        if (argument.startsWith(toTrim)) argument = argument.replaceFirst(toTrim+" +","");
        return argument;
    }
}
