package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

import java.io.Serializable;

public abstract class IItem implements Serializable
{
    String name;
    String description;
    String inventoryDescription;
    boolean pickable;

    public String getDescription()
    {
        return description;
    }

    public String getName()
    {
        return name;
    }

    public String getInventoryDescription()
    {
        return inventoryDescription;
    }

    private boolean isPickable()
    {
        return pickable;
    }

    public void pick(Player player)
    {
        String pickFailed = "This is not something I can pick!";
        if (!this.isPickable())
            GameEngine.textOutput(pickFailed);
        else
        {
            player.addToInventory(this);
            GameEngine.textOutput("Picked " + this.getName() + ".");
            player.getLocation().removeItem(this);
        }
    }
}
