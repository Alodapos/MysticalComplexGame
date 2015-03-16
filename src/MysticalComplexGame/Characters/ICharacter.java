package MysticalComplexGame.Characters;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;

public interface ICharacter
{
    IScene getCurrentLocation();

    void setCurrentLocation(IScene currentLocation);

    String getName();

    void setName(String name);

    void addToInventory(IItem itemToAdd);

    void removeFromInventory(IItem itemToRemove);

    ArrayList<IItem> getInventory();

}
