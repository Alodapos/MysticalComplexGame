package MysticalComplexGame.Items;

import MysticalComplexGame.Character;
import MysticalComplexGame.Scene;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ShinyRock implements IItem
{
    private String name;
    private String description;
    private String inventoryDescription;
    private String useFailed;
    private List<String> tags;

    public ShinyRock(String...tags)
    {
        name = "rock";
        description = "A gold , shiny rock lies on the floor...its...dazzling...";
        inventoryDescription = "A dazzling-shiny rock.";
        useFailed = "I can't use a rock.";
        this.tags = new ArrayList<String>();
        Collections.addAll(this.tags,tags);
    }
    @Override
    public void useItem(Character player, List<Scene> scenes)
    {
        System.out.println(useFailed);
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
