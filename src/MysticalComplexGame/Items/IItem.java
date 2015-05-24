package MysticalComplexGame.Items;

import MysticalComplexGame.Connector;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

import java.io.Serializable;

public abstract class IItem implements Serializable
{
    protected String name;
    protected String description;
    protected String inventoryDescription;
    protected boolean pickable;
    protected String pickFailed = "This is not something I can pick!";

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

    public boolean isPickable()
    {
        return pickable;
    }

    public void makePickable()
    {
        pickable = true;
    }

    public void makeUnpickable()
    {
        pickable = false;
    }

    public void pick(Player player)
    {
        if (!this.isPickable()) GameEngine.textOutput(pickFailed);
        else
        {
            player.addToInventory(this);
            GameEngine.textOutput("Picked " + this.getName() + ".");
            player.getLocation().removeItem(this);
        }
    }

    public void setConnectionToOpen(Connector connectionToOpen)
    {

    }
}
