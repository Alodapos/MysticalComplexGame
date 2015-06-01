package MysticalComplexGame.Items;

import MysticalComplexGame.Player;
import MysticalComplexGame.Connector;
import MysticalComplexGame.GameEngine;

public class FelrockSign extends IItem implements ReadableItem
{
    private String text;
    private Connector toOpen;

    public FelrockSign(Connector toOpen)
    {
        pickable = false;
        name = "sign";
        description = "There is a sign by the end of the path.";
        text = "Welcome to Felrock Village!";
        this.toOpen = toOpen;
    }

    @Override
    public void read(Player player)
    {
        GameEngine.textOutput(text);
        toOpen.openConnection();
    }
}
