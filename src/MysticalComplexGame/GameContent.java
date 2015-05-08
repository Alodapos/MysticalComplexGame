package MysticalComplexGame;

import MysticalComplexGame.Commands.ICommand;
import MysticalComplexGame.Items.IItem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class GameContent implements Serializable
{
    private transient Map<String, ICommand> commandMap;
    private Map<String, Scene> sceneMap;
    private Map<String, IItem> itemMap;
    private Player player;

    public GameContent()
    {
        sceneMap = new HashMap<>();
        itemMap = new HashMap<>();
        player = new Player();
    }

    public void initializeCommands()
    {
        commandMap = new HashMap<>();
    }

    public void setPlayer(Player player)
    {
        this.player = player;
    }

    public Player getPlayer()
    {
        return player;
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
