package MysticalComplexGame.Characters;

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
}
