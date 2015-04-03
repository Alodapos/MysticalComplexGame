package MysticalComplexGame.Items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ShinyRock implements IItem
{
    private String name;
    private String description;
    private String inventoryDescription;
    private List<String> tags;

    public ShinyRock(String...tags)
    {
        name = "rock";
        description = "A gold , shiny rock lies on the floor...its...dazzling...";
        inventoryDescription = "A dazzling-shiny rock.";
        this.tags = new ArrayList<String>();
        Collections.addAll(this.tags,tags);
    }
    @Override
    public String getInventoryDescription() {
        return inventoryDescription;
    }

    @Override
    public String getDescription() {
        return description;
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
