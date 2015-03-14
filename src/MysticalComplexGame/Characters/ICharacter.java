package MysticalComplexGame.Characters;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scenes.IScene;

/**
 * Created by sakis on 10-Mar-15.
 */
public interface ICharacter
{
    IScene getCurrentLocation();

    void setCurrentLocation(IScene currentLocation);

    String getName();

    void setName(String name);

    public void addToInventory(IItem itemToAdd);

    public void removeFromInventory(IItem itemToRemove);
}
