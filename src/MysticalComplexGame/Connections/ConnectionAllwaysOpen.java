package MysticalComplexGame.Connections;

import MysticalComplexGame.Character;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scene;
import MysticalComplexGame.State;

public class ConnectionAllwaysOpen implements IConnector
{
    private final Scene nextScene;

    public ConnectionAllwaysOpen(Scene scene)
    {
        this.nextScene = scene;
    }
    @Override
    public Scene getNextScene() {
       return  this.nextScene;
    }
    @Override
    public String getDescription() {
        return null;
    }
    @Override
    public State getState() {
        return State.OPEN;
    }
    @Override
    public void changeState(State state)
    {}
    @Override
    public boolean isOpen()
    {
        return true;
    }
    @Override
    public void openConnection(Character character, IItem key)
    {}
}
