package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.Scene;
import java.util.Map;

public class LookCommand implements ICommand
{

    String name;
    String invalidArgument;
    public LookCommand()
    {
        name = "look";
        invalidArgument = "I understood as far as you wanted to look";
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void executeCommand(Character character, String argument, Map<String, Scene> scenes)
    {
        if (argument.equals("") || argument.equals("around")) character.getLocation().printDescription();
        else System.out.println(invalidArgument);
    }
}
