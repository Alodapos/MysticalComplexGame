package MysticalComplexGame.Items;

import MysticalComplexGame.ConnectionState;
import MysticalComplexGame.Player;
import MysticalComplexGame.Connector;
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
    public void read(Player player)
    {
        GameEngine.textOutput(text);
        for (Connector connection : player.getLocation().getConnections())
            if (connection.getState() == ConnectionState.CLOSED)
                if (!connection.isOpen()) connection.openConnection(this);
    }
}
