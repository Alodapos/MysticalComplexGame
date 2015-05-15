package MysticalComplexGame;

import MysticalComplexGame.Items.IItem;

import java.util.HashMap;

public class Player
{
    private String name;
    private Scene currentLocation;
    private HashMap<String, IItem> inventory = new HashMap<String, IItem>();
    private int thirstLevel;

    public Player(Scene location)
    {
        currentLocation = location;
        thirstLevel = 10;
    }

    public Scene getLocation()
    {
        return currentLocation;
    }
    public void setLocation(Scene currentLocation)
    {
        this.currentLocation = currentLocation;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void addToInventory(IItem itemToAdd)
    {
        inventory.put(itemToAdd.getName(), itemToAdd);
    }
    public void removeFromInventory(IItem item)
    {
        inventory.remove(item.getName(),item);
    }
    public HashMap<String,IItem> getInventory()
    {
        return inventory;
    }

    public int getThirstLevel()
    {
        return thirstLevel;
    }

    public void setThirstLevel(int thirstLevel)
    {
        this.thirstLevel = thirstLevel;
    }
}
