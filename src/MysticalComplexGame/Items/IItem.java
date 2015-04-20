package MysticalComplexGame.Items;

import java.util.List;

public abstract class IItem
{
    protected String name;
    protected String description;
    protected String inventoryDescription;
    protected List<String> tags;

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

    public List<String> getTags()
    {
        return tags;
    }
}
