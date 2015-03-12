package ZorkGame.Characters;

import ZorkGame.Scenes.IScene;

/**
 * Created by sakis on 10-Mar-15.
 */
public class PlayerCharacter implements ICharacter {

    private String name;
    private IScene currentLocation;
    //private ArrayList<IItem> inventory;
    //TODO inventory methods


    @Override
    public IScene getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void setCurrentLocation(IScene currentLocation) {
        this.currentLocation = currentLocation;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
