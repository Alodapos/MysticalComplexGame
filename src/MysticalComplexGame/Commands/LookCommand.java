package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.GameContent;

public class LookCommand implements ICommand
{

    private String name;
    private String invalidArgument;
    private String skippedWord;
    public LookCommand()
    {
        name = "look";
        invalidArgument = "I understood as far as you wanted to look";
        skippedWord = "around";
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void executeCommand(Character character, String argument, GameContent content)
    {
        argument = trimArgument(argument,skippedWord);
        if (argument.equals("")) character.getLocation().printDescription();
        else System.out.println(invalidArgument);
    }
    private String trimArgument(String argument, String toTrim)
    {
        if (argument.startsWith(toTrim)) argument = argument.replaceFirst(toTrim + " +","");
        return argument;
    }
}
