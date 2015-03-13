package Mystical_Complex_Game.Characters;

import Mystical_Complex_Game.Scenes.IScene;

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
