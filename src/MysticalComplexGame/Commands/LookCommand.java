package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;

public class LookCommand implements ICommand
{

    @Override
    public String getName()
    {
        return "look";
    }

    @Override
    public void executeCommand(ICharacter character, String argument, ArrayList<IScene> scenes)
    {
        argument = argument.trim();
        String actionFailed = "I understood as far as you wanted to look.";
        if (argument.equals("") || argument.equals("around")) character.getCurrentLocation().printDescription();
        else System.out.println(actionFailed);
    }
}
