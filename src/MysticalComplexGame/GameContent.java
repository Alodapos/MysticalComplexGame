package MysticalComplexGame;

import MysticalComplexGame.Commands.ICommand;

import java.util.HashMap;
import java.util.Map;

public class GameContent
{
    private Map<String, ICommand> commandMap;
    private Map<String, Scene> sceneMap;
    private Map<String, Character> characterMap;

    public GameContent()
    {
        commandMap = new HashMap<String, ICommand>();
        sceneMap = new HashMap<String, Scene>();
        characterMap = new HashMap<String, Character>();
    }
    public void addCharacter(Character character)
    {
        this.characterMap.put(character.getName(),character);
    }
    public void addCommand(ICommand command)
    {
        this.commandMap.put(command.getName(),command);
    }
    public void addScene(Scene scene)
    {
        this.sceneMap.put(scene.getName(),scene);
    }
    public Character getCharacter(String character)
    {
        return this.characterMap.get(character);
    }
    public ICommand getCommand(String command)
    {
        return this.commandMap.get(command);
    }
    public Scene getScene(String scene)
    {
        return this.sceneMap.get(scene);
    }
}
