package MysticalComplexGame.Items;

public abstract class IItem
{
    protected String name;
    protected String description;
    protected String inventoryDescription;
    protected boolean pickable;

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
}
