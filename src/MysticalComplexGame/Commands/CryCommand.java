package MysticalComplexGame.Commands;

import MysticalComplexGame.Character;
import MysticalComplexGame.Scene;
import java.util.Map;

public class CryCommand implements ICommand
{

    @Override
    public String getName()
    {
        return "cry";
    }

    @Override
    public void executeCommand(Character character, String argument, Map<String, Scene> scenes)
    {
        argument = argument.trim();
        String actionFailed = "I understood as far as you wanted to CRI!";
        if (!argument.equals("")) System.out.println(actionFailed);
        else System.out.println("I cri evertiem 2 m8 ;(");
    }
}
