package MysticalComplexGame.Connections;

import MysticalComplexGame.*;
import MysticalComplexGame.Character;
import MysticalComplexGame.Items.IItem;

public class ConnectionPassive implements IConnector
{
    private State state;
    private String description;
    private Scene nextScene;
    private IItem key;

    public ConnectionPassive(String description, Scene nextScene, IItem key)
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
    public State getState() {
        return state;
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
    public void openConnection(Character character, IItem key)
    {
        if (character.getInventory().get(this.key.getName()) != null) changeState(State.OPEN);
    }
}
