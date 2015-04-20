package MysticalComplexGame;

import MysticalComplexGame.Items.IItem;

import java.util.HashMap;

public class Player
{
    static private String name;
    static private Scene currentLocation;
    static private HashMap<String, IItem> inventory = new HashMap<String, IItem>();
    static private int thirstLevel = 10;
    public static Scene getLocation()
    {
        return currentLocation;
    }
    public static void setLocation(Scene currentLocation)
    {
        Player.currentLocation = currentLocation;
    }
    public static String getName()
    {
        return name;
    }
    public static void setName(String name)
    {
        Player.name = name;
    }
    public static void addToInventory(IItem itemToAdd)
    {
        inventory.put(itemToAdd.getName(), itemToAdd);
    }
    public static void removeFromInventory(IItem item)
    {
        inventory.remove(item.getName(),item);
    }
    public static HashMap<String,IItem> getInventory()
    {
        return inventory;
    }

    public static int getThirstLevel()
    {
        return thirstLevel;
    }

    public static void setThirstLevel(int thirstLevel)
    {
        Player.thirstLevel = thirstLevel;
    }
}
