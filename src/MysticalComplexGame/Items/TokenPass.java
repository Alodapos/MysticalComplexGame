package MysticalComplexGame.Items;

import MysticalComplexGame.Connector;
import MysticalComplexGame.Player;

public class TokenPass extends IItem implements KeyItem
{
    private final Connector toOpen;

    public TokenPass(Connector toOpen)
    {
        pickable = true;
        name = "token pass";
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