package MysticalComplexGame;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.WeaponItem;

import java.io.Serializable;
import java.util.HashMap;

public class Player implements Serializable
{
    private String name;
    private Scene currentLocation;
    private WeaponItem equippedWeapon;
    private HashMap<String, IItem> inventory = new HashMap<String, IItem>();
    private int thirstLevel;

    public WeaponItem getEquippedWeapon()
    {
        return equippedWeapon;
    }

    public void equipWeapon(WeaponItem weapon)
    {
        if(getEquippedWeapon() != null) weapon.unequip(this);
        if(getEquippedWeapon() == null)
        {
            equippedWeapon = weapon;
            removeFromInventory((IItem)weapon);
            GameEngine.textOutput("You equip a " + ((IItem) weapon).getName() + ".");
        }
    }

    public void unequipWeapon()
    {
        addToInventory((IItem)equippedWeapon);
        GameEngine.textOutput(((IItem) equippedWeapon).getName() + " unequipped.");
        equippedWeapon = null;
    }

    public Player()
    {
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
