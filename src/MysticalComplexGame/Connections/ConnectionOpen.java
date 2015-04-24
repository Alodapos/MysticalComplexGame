package MysticalComplexGame.Connections;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scene;

public class ConnectionOpen implements IConnector
{
    private final Scene nextScene;

    public ConnectionOpen(Scene scene)
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
    public void changeState(State state)
    {}
    @Override
    public boolean isOpen()
    {
        return true;
    }
    @Override
    public void openConnection(IItem key)
    {}
}
