package MysticalComplexGame;

import MysticalComplexGame.Items.IItem;
import java.util.HashMap;
import java.util.Map;

public class Scene
{
    private String description;
    private String name;
    private Map<String, IItem> items;
    private Map<Direction,String> connections;

    public Scene(String name, String description,String northPlace, String southPlace, String eastPlace, String westPlace,IItem...items)
    {
        this.connections = new HashMap<Direction, String>();
        this.items = new HashMap<String,IItem>();
        this.name = name;
        this.description = description;
        for (IItem item: items) this.items.put(item.getName(),item);
        connections.put(Direction.NORTH,northPlace);
        connections.put(Direction.SOUTH,southPlace);
        connections.put(Direction.EAST,eastPlace);
        connections.put(Direction.WEST,westPlace);
    }


    public String getConnection(Direction direction)
    {
        return this.connections.get(direction);
    }

    public void setConnection(Direction direction,String place)
    {
        this.connections.remove(direction);
        this.connections.put(direction,place);
    }

    public void printDescription()
    {
        System.out.println("\t\t\t\t\t\""+this.name +"\""+"\n");
        System.out.println(this.description);
        for (Map.Entry<String, IItem> item : items.entrySet()) System.out.println(item.getValue().getDescription());
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
