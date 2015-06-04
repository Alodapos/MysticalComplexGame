package MysticalComplexGame.Items;

import MysticalComplexGame.Connector;
import MysticalComplexGame.Player;

public class SilverToken extends IItem implements KeyItem
{
    private final Connector toOpen;

    public SilverToken(Connector toOpen)
    {
        pickable = true;
        name = "silver token";
        description = " ";
        inventoryDescription = "A token pass from General Cornelius.";
        this.toOpen = toOpen;
    }

    @Override
    public void pick(Player player)
    {
        super.pick(player);
        toOpen.openConnection();
    }
}