package MysticalComplexGame;

import MysticalComplexGame.Commands.ICommand;
import MysticalComplexGame.Items.IItem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameContent implements Serializable
{
    private transient Map<String, ICommand> commands;
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<Scene> scenes;
    private final Map<String, IItem> items;
    private Player player;

    public GameContent()
    {
        scenes = new LinkedList<>();
        items = new HashMap<>();
        player = new Player();
    }

    public void initializeCommands()
    {
        commands = new HashMap<>();
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
        commands.put(command.getKey(),command);
    }

    public void addItem(IItem item)
    {
        items.put(item.getName(),item);
    }

    public IItem stringToItem(String item)
    {
        return items.get(item);
    }

    public void addScene(Scene scene)
    {
        scenes.add(scene);
    }

    public ICommand stringToCommand(String command)
    {
        return commands.get(command);
    }
}
