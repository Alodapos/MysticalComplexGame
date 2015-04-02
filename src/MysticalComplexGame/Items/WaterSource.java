package MysticalComplexGame.Items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaterSource implements IItem
{

    private String name;
    private String description;
    private String inventoryDescription;
    private List<String> tags;

    public WaterSource(String...tags)
    {
        name = "water";
        description = "";
        inventoryDescription = "";
        this.tags = new ArrayList<String>();
        Collections.addAll(this.tags, tags);
    }
    @Override
    public String getInventoryDescription() {
        return inventoryDescription;
    }

    @Override
    public void setInventoryDescription(String inventoryDescription) {
        this.inventoryDescription = inventoryDescription;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<String> getTags()
    {
        return this.tags;
    }
}
