package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;
import java.util.Arrays;

public class LookCommand implements ICommand
{

    private final String name= "look";
    private final String actionFailed = "I understood as far as you wanted to look.";

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void executeCommand(ICharacter character, String argument, ArrayList<IScene> scenes)
    {
        argument = argument.trim();
        if (argument.equals("") || argument.equals("around")) character.getCurrentLocation().printDescription();
        else System.out.println(actionFailed);
    }
}
