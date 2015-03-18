package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;

public class CryCommand implements ICommand
{

    private final String name= "cry";
    private final String actionFailed = "I understood as far as you wanted to CRI!";

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public void executeCommand(ICharacter character, String argument, ArrayList<IScene> scenes)
    {
        argument = argument.trim();
        if (!argument.equals("")) System.out.println(actionFailed);
        else System.out.println("I cri evertiem 2 m8 ;(");
    }
}
