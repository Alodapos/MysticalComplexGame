package MysticalComplexGame.Items;

import MysticalComplexGame.Character;
import MysticalComplexGame.Scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Flask implements IItem
{
    private String name;
    private String description;
    private String inventoryDescription;
    private String useFailed;
    private String useSuccessful;
    private List<String> tags;

    public Flask(String...tags)
    {
        name = "flask";
        description= "A small sized, leather flask filled at 3/5 with water.";
        inventoryDescription = "A small flask.";
        useFailed = "There is no water source nearby.";
        useSuccessful = "You fill your flask with water.";
        this.tags = new ArrayList<String>();
        Collections.addAll(this.tags, tags);

    }
    @Override
    public void useItem(Character player, List<Scene> scenes)
    {
        if(!player.getInventory().containsKey("water"))
            System.out.println(useFailed);
        else
        //TODO else
            System.out.println(useSuccessful);
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
