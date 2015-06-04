package MysticalComplexGame;

import MysticalComplexGame.Items.IItem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Scene implements Serializable
{
    private final String description;
    private final String name;
    private final Map<String, IItem> items;
    private final Map<Direction, Connector> connections;

    public Scene(String name, String description)
    {
        this.connections = new HashMap<>();
        this.items = new HashMap<>();
        this.name = name;
        this.description = description;
    }

    public Connector getConnection(Direction direction)
    {
        return this.connections.get(direction);
    }

    public void printDescription()
    {
        GameEngine.textOutput("\t\t\t\t\t\"" + this.name + "\"" + "\n");
        GameEngine.textOutput(this.description);
        for (Map.Entry<String, IItem> item : items.entrySet()) GameEngine.textOutput(item.getValue().getDescription());
    }

    public void addConnection(Direction direction, Connector connection)
    {
        connections.put(direction, connection);
    }

    public void addItem(IItem item)
    {
        this.items.put(item.getName(),item);
    }

    public void removeItem(IItem item)
    {
        items.remove(item.getName(),item);
    }

    public Map<String,IItem> getItems()
    {
        return this.items;
    }

    public String getName()
    {
        return name;
    }
}
