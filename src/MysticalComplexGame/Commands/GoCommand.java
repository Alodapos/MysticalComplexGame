package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;
import java.util.ArrayList;
import java.util.Arrays;

public class GoCommand implements ICommand
{

    private final ArrayList<String> directions = new ArrayList<String>(Arrays.asList("north","south","east","west"));

    @Override
    public String getName()
    {
        return "go";
    }

    @Override
    public void executeCommand(ICharacter character, String argument, ArrayList<IScene> scenes)
    {
        argument = argument.trim();
        int compassIndex = directions.indexOf(argument);
        String missingArgument = "You'll have to say which compass direction to go in.";
        String actionFailed = "You can't see any such thing.";
        if (argument.matches("")) System.out.println(missingArgument); // if not argument at all
        else if (compassIndex == -1)  System.out.println(actionFailed); //if invalid argument (not compass direction)
        else //we got the argument to be north/south/east/west, now check the text
        {
            ArrayList<String> sceneNames = new ArrayList<String>();
            for (IScene scene : scenes) sceneNames.add(scene.getSceneName());       //make a table with scene names to search on it
            int nextSceneIndex = sceneNames.indexOf(character.getCurrentLocation().getNextScene(compassIndex));
            if (nextSceneIndex == -1 ) System.out.println(character.getCurrentLocation().getNextScene(compassIndex)); //there's no scene, but error message
            else
            {
                //CHANGE SCENE
                character.setCurrentLocation(scenes.get(nextSceneIndex));
                character.getCurrentLocation().printDescription();
            }
        }
    }
}
