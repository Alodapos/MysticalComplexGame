package MysticalComplexGame;

import MysticalComplexGame.Commands.ICommand;

import java.util.HashMap;
import java.util.Map;

public class GameContent
{
    private Map<String, ICommand> commandMap;
    private Map<String, Scene> sceneMap;

    public GameContent()
    {
        commandMap = new HashMap<String, ICommand>();
        sceneMap = new HashMap<String, Scene>();
    }

    public void addCommand(ICommand command)
    {
        commandMap.put(command.getKey(),command);
    }
    public void addScene(Scene scene)
    {
        this.sceneMap.put(scene.getName(),scene);
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
