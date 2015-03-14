package MysticalComplexGame.Commands;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.*;

/**
 * Created by sakis on 09-Mar-15.
 */
public class GoCommand implements ICommand
{

    private final String name= "go";
    private final String missingArgument = "You'll have to say which compass direction to go in.";
    private final String actionFailed = "You can't see any such thing.";
    private final String PATTERN = "^(north|south|east|west|up|down)$";
    private final Pattern pattern = Pattern.compile(PATTERN);
    private final ArrayList<String> directions = new ArrayList<String>(Arrays.asList("north","south","east","west","up","down"));
    private final ArrayList<String> noGoMessages = new ArrayList<String>(Arrays.asList("You cannot go that way.","The door is locked.","The gate is sealed and there is no keyhole."));
    private Matcher matcher;


    @Override
    public String getName()
    {
        return this.name;
    }
    @Override
    public String getActionFailed()
    {
        return this.actionFailed;
    }
    @Override
    public void executeCommand(ICharacter character, String argument, ArrayList<IScene> scenes)
    {
        argument = argument.trim();
        matcher = pattern.matcher(argument);
        int desiredDirection, nextSceneId;
        if (argument.matches(""))
        {
            System.out.println(missingArgument);
        }
        else if (matcher.find())
        {
            desiredDirection = directions.indexOf(matcher.group()); //gets compass direction as integer
            nextSceneId = character.getCurrentLocation().getNextScene(desiredDirection); //gets ID for the scene at that direction
            if (nextSceneId > 0)
            {
                for (IScene scene: scenes)
                {
                    if (scene.getSceneId() == nextSceneId)
                    {
                        character.setCurrentLocation(scenes.get(scenes.indexOf(scene)));
                        character.getCurrentLocation().printDescription();
                    }
                }
            }
            else
            {
                nextSceneId = Math.abs(nextSceneId);
                System.out.println(noGoMessages.get(nextSceneId));
            }
        }
        else
        {
            System.out.println(actionFailed);
        }
    }
}
