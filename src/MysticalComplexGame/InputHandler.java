package MysticalComplexGame;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;
import MysticalComplexGame.Commands.IVerb;

import java.util.ArrayList;
import java.util.regex.*;
/**
 * Created by sakis on 09-Mar-15.
 */
public class InputHandler
{

    private final Pattern pattern = Pattern.compile("(\\w+)(.*)");
    private Matcher matcher;
    private ArrayList<IVerb> verbList = new ArrayList<IVerb>();
    private ArrayList<String> commandNameList = new ArrayList<String>();
    private ArrayList<IScene> scenesList = new ArrayList<IScene>();

    public void handle(String userInput,ICharacter character)
    {
        userInput = userInput.trim();
        userInput = userInput.toLowerCase();
        int commandPosition;
        //this.matcher.reset(); no clue what dis be doing here
        this.matcher = pattern.matcher(userInput);
        if (matcher.find())
        {
            commandPosition = commandNameList.indexOf(matcher.group(1));
            if (commandPosition == -1)  System.out.println("This is not a verb I recognize!");
            else verbList.get(commandPosition).executeAction(character, matcher.group(2), this);
        }
    }

    public void addVerbs(IVerb verbToAdd)
    {
        this.verbList.add(verbToAdd);
        this.commandNameList.add(verbToAdd.getName());
    }

    public void addScene(IScene sceneToAdd)
    {
        this.scenesList.add(sceneToAdd);
    }

    public ArrayList<IScene> getScenesList()
    {
        return scenesList;
    }
}

