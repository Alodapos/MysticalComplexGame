package MysticalComplexGame;

import MysticalComplexGame.Items.IItem;
import java.util.HashMap;
import java.util.Map;

public class Scene
{
    private String description;
    private String name;
    private Map<String, IItem> items;
    private Map<Direction, SceneConnection> connections;

    public Scene(String name, String description,IItem...items)
    {
        this.connections = new HashMap<Direction, SceneConnection>();
        this.items = new HashMap<String,IItem>();
        this.name = name;
        this.description = description;
        for (IItem item: items) this.items.put(item.getName(),item);
    }

    public SceneConnection getConnection(Direction direction)
    {
        return this.connections.get(direction);
    }

    public void printDescription()
    {
        System.out.println("\t\t\t\t\t\""+this.name +"\""+"\n");
        System.out.println(this.description);
        for (Map.Entry<String, IItem> item : items.entrySet()) System.out.println(item.getValue().getDescription());
    }

    public void addConnection(Direction direction, SceneConnection connection)
    {
        connections.put(direction,connection);
    }

    public void addItem(IItem item)
    {
        this.items.put(item.getName(),item);
    }

    public void removeItem(String item)
    {
        this.items.remove(item);
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
