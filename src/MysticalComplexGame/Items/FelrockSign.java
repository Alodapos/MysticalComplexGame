package MysticalComplexGame.Items;

import MysticalComplexGame.Player;
import MysticalComplexGame.Connections.ConnectionActive;
import MysticalComplexGame.Connections.IConnector;
import MysticalComplexGame.GameEngine;

public class FelrockSign extends IItem implements ReadableItem
{
    private String text;

    public FelrockSign()
    {
        pickable = false;
        name = "sign";
        description = "There is a sign by the end of the path.";
        text = "Welcome to Felrock Village!";
    }

    @Override
    public void read()
    {
        GameEngine.textOutput(text);
        for (IConnector connection : Player.getLocation().getConnections())
            if (connection instanceof ConnectionActive)
                if (!connection.isOpen()) connection.openConnection(this);
    }
}
