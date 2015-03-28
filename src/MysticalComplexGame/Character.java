package MysticalComplexGame;

import MysticalComplexGame.Items.IItem;

import java.util.HashMap;

public class Character
{
    private String name;
    private Scene currentLocation;
    private HashMap<String, IItem> inventory;
    private int thirstLevel;

    public Character(String name, Scene startingLocation)
    {
        this.name = name;
        this.currentLocation = startingLocation;
        inventory = new HashMap<String, IItem>();
        thirstLevel = 10;
    }
    public Scene getLocation()
    {
        return this.currentLocation;
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
        this.inventory.put(itemToAdd.getName(), itemToAdd);
    }
    public void removeFromInventory(String item)
    {
        this.inventory.remove(item);
    }
    public HashMap<String,IItem> getInventory()
    {
        return this.inventory;
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
