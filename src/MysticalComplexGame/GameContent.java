package MysticalComplexGame;

import MysticalComplexGame.Commands.ICommand;
import MysticalComplexGame.Items.IItem;

import java.util.HashMap;
import java.util.Map;

public class GameContent
{
    private Map<String, ICommand> commandMap;
    private Map<String, Scene> sceneMap;
    private Map<String, IItem> itemMap;

    public GameContent()
    {
        commandMap = new HashMap<String, ICommand>();
        sceneMap = new HashMap<String, Scene>();
        itemMap = new HashMap<String,IItem>();
    }

    public void addCommand(ICommand command)
    {
        commandMap.put(command.getKey(),command);
    }
    public void addItem(IItem item)
    {
        itemMap.put(item.getName(),item);
    }

    public IItem stringToItem(String item)
    {
        return itemMap.get(item);
    }

    public void removeItem(IItem item)
    {
        itemMap.remove(item.getName());
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
