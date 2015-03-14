package MysticalComplexGame;

import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;
import MysticalComplexGame.Commands.ICommand;

import java.util.ArrayList;
import java.util.regex.*;
/**
 * Created by sakis on 09-Mar-15.
 */
public class InputHandler
{

    private final Pattern pattern = Pattern.compile("(\\w+)(.*)"); //a word, and something else, or nothing else
    private final String commandNotFound = "This is not a command i recognize!";
    private Matcher matcher;
    private ArrayList<ICommand> commandList = new ArrayList<ICommand>(); //commands
    private ArrayList<IScene> scenesList = new ArrayList<IScene>();     //scenes
    private ArrayList<String> commandNameList = new ArrayList<String>(); //scene names


    public void handle(String userInput,ICharacter character)
    {
        userInput = userInput.trim();
        userInput = userInput.toLowerCase();
        int commandIndex;
        this.matcher = pattern.matcher(userInput);
        if (matcher.find()) //if we find a word
        {
            commandIndex = commandNameList.indexOf(matcher.group(1));
            if (commandIndex == -1)  System.out.println(commandNotFound);
            else commandList.get(commandIndex).executeCommand(character, matcher.group(2), scenesList);
        }
    }

    public void addVerbs(ICommand commandToAdd)
    {
        this.commandList.add(commandToAdd);
        this.commandNameList.add(commandToAdd.getName());
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

