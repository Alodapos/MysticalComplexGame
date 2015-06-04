package MysticalComplexGame;

import java.io.Serializable;

public class Connector implements Serializable
{
    private ConnectionState connectionState;
    private final String description;
    private final Scene nextScene;
    private final String unlockText;

    public Connector(String description)
    {
        this.description = description;
        connectionState = ConnectionState.CLOSED;
        nextScene = null;
        unlockText = null;
    }

    public Connector(Scene nextScene)
    {
        this.nextScene = nextScene;
        description = null;
        unlockText = null;
        connectionState = ConnectionState.OPEN;
    }

    public Connector(Scene nextScene,String description,String unlockText)
    {
        this.nextScene = nextScene;
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

    public boolean isClosed()
    {
        return connectionState == ConnectionState.CLOSED;
    }

    public void openConnection()
    {
        if (connectionState == ConnectionState.CLOSED)
        {
            connectionState = ConnectionState.OPEN;
            GameEngine.textOutput(unlockText);
        }
    }
}
