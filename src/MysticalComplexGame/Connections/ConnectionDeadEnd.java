package MysticalComplexGame.Connections;

import MysticalComplexGame.*;
import MysticalComplexGame.Character;
import MysticalComplexGame.Items.IItem;

public class ConnectionDeadEnd implements IConnector
{
    private String description;

    public ConnectionDeadEnd(String description)
    {
        this.description = description;
    }
    @Override
    public Scene getNextScene() {
       return  null;
    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public State getState() {
        return State.CLOSED;
    }
    @Override
    public void changeState(State state)
    {}
    @Override
    public boolean isOpen()
    {
        return false;
    }
    @Override
    public void openConnection(Character character, IItem key)
    {}
}
