package MysticalComplexGame;

import MysticalComplexGame.Commands.ICommand;

import java.util.HashMap;
import java.util.Map;

class InputHandler
{
    private Map<String, ICommand> commands;
    private Map<String, Scene> scenes;
    String commandNotFound;

    public InputHandler()
    {
        commandNotFound = "This is not a command that i recognize!";
        commands = new HashMap<String, ICommand>();
        scenes = new HashMap<String, Scene>();
    }

    public void handleInput(String userInput, Character character)
    {
        userInput = userInput.toLowerCase();
        String[] input = new String[2];
        if (userInput.contains(" ")) input = userInput.split(" ",2);
        else
        {
            input[0] = userInput;
            input[1] = "";
        }

        if (commands.containsKey(input[0])) commands.get(input[0]).executeCommand(character,input[1].trim(),scenes);
        else System.err.println(commandNotFound);
    }

    public void addCommand(ICommand commandToAdd)
    {
        this.commands.put(commandToAdd.getName(),commandToAdd);
    }

    public void addScene(Scene scene)
    {
        this.scenes.put(scene.getName(), scene);
    }
}


