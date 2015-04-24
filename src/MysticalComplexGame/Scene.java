package MysticalComplexGame;

import MysticalComplexGame.Connections.IConnector;
import MysticalComplexGame.Items.IItem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Scene
{
    private String description;
    private String name;
    private Map<String, IItem> items;
    private Map<Direction, IConnector> connections;

    public Scene(String name, String description,IItem...items)
    {
        this.connections = new HashMap<Direction, IConnector>();
        this.items = new HashMap<String,IItem>();
        this.name = name;
        this.description = description;
        for (IItem item: items) this.items.put(item.getName(),item);
    }

    public IConnector getConnection(Direction direction)
    {
        return this.connections.get(direction);
    }

    public void printDescription()
    {
        GameEngine.textOutput("\t\t\t\t\t\"" + this.name + "\"" + "\n");
        GameEngine.textOutput(this.description);
        for (Map.Entry<String, IItem> item : items.entrySet()) GameEngine.textOutput(item.getValue().getDescription());
    }

    public void addConnection(Direction direction, IConnector connection)
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

    public Collection<IConnector> getConnections()
    {
        return this.connections.values();
    }
}
