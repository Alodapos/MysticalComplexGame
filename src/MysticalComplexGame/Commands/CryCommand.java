package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;

public class CryCommand implements ICommand
{

    @Override
    public String getName()
    {
        return "cry";
    }

    @Override
    public void executeCommand(ICharacter character, String argument, ArrayList<IScene> scenes)
    {
        argument = argument.trim();
        String actionFailed = "I understood as far as you wanted to CRI!";
        if (!argument.equals("")) System.out.println(actionFailed);
        else System.out.println("I cri evertiem 2 m8 ;(");
    }
}
