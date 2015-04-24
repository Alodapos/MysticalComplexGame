package MysticalComplexGame;

import MysticalComplexGame.ConnectionState;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Scene;

public class Connector
{
    private ConnectionState connectionState;
    private String description;
    private Scene nextScene;
    private IItem key;
    private String unlockText;

    public Connector(String description)
    {
        this.description = description;
        connectionState = ConnectionState.OPEN;
        key = null;
        nextScene = null;
        unlockText = null;
    }

    public Connector(Scene nextScene)
    {
        this.nextScene = nextScene;
        description = null;
        key = null;
        unlockText = null;
        connectionState = ConnectionState.OPEN;
    }

    public Connector(Scene nextScene,IItem key,String description)
    {
        this.nextScene = nextScene;
        this.key = key;
        unlockText = null;
        this.description = description;
        connectionState = ConnectionState.PASSIVE;
    }

    public Connector(Scene nextScene,IItem key,String description,String unlockText)
    {
        this.nextScene = nextScene;
        this.key = key;
        this.unlockText = unlockText;
        this.description = description;
        connectionState = ConnectionState.CLOSED;
    }

    public Scene getNextScene()
    {
        return nextScene;
    }

    public String getDescription()
    {
       return description;
    }

    public void changeState(ConnectionState connectionState)
    {
        this.connectionState = connectionState;
    }

    public boolean isOpen()
    {
        return connectionState == ConnectionState.OPEN;
    }

    public void openConnection(IItem key)
    {
        if (key == this.key)
        {
            changeState(ConnectionState.OPEN);
            GameEngine.textOutput(unlockText);
        }
    }

    public ConnectionState getState()
    {
        return connectionState;
    }

    public IItem getKey()
    {
        return key;
    }
}
