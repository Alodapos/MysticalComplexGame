package MysticalComplexGame.Items;

import java.util.ArrayList;
import java.util.Collections;

public class ShinyRock extends IItem
{
    public ShinyRock(String...tags)
    {
        name = "rock";
        description = "A gold , shiny rock lies on the floor...its...dazzling...";
        inventoryDescription = "A dazzling-shiny rock.";
        this.tags = new ArrayList<String>();
        Collections.addAll(this.tags,tags);
    }
}
