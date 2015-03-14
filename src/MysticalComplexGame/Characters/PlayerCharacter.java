package MysticalComplexGame.Characters;

import MysticalComplexGame.Scenes.IScene;
import MysticalComplexGame.Items.IItem;
import java.util.ArrayList;

/**
 * Created by sakis on 10-Mar-15.
 */
public class PlayerCharacter implements ICharacter
{

    private String name;
    private IScene currentLocation;
    private ArrayList<IItem> inventory = new ArrayList<IItem>();


    @Override
    public IScene getCurrentLocation()
    {
        return currentLocation;
    }

    @Override
    public void setCurrentLocation(IScene currentLocation)
    {
        this.currentLocation = currentLocation;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public void addToInventory(IItem itemToAdd)
    {
        this.inventory.add(itemToAdd);
    }

    @Override
    public void removeFromInventory(IItem itemToRemove)
    {
        this.inventory.remove(itemToRemove);
        this.inventory.trimToSize();
    }
}
