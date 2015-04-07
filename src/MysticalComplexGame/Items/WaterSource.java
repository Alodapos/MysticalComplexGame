package MysticalComplexGame.Items;

import java.util.ArrayList;
import java.util.List;

public class WaterSource implements IItem
{

    private String name;
    public WaterSource()
    {
        name = "water";
    }
    @Override
    public String getInventoryDescription() {
        return null ;
    }


    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public List<String> getTags()
    {
        List<String> noTags= new ArrayList<String>();
        return noTags;
    }
}
