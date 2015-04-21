package MysticalComplexGame.Connections;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scene;

public class ConnectionActive implements IConnector
{
    private State state;
    private String description;
    private Scene nextScene;
    private IItem key;

    public ConnectionActive(String description, Scene nextScene, IItem key)
    {
        this.state = State.CLOSED;
        this.description = description;
        this.nextScene = nextScene;
        this.key = key;
    }
    @Override
    public Scene getNextScene() {
        return nextScene;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public void changeState(State state)
    {
        this.state = state;
    }
    @Override
    public boolean isOpen()
    {
        if (state == State.OPEN) return true;
        else return false;
    }
    @Override
    public void openConnection(IItem key)
    {
        if (key == this.key) changeState(State.OPEN);
    }
}
