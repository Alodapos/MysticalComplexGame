package MysticalComplexGame.Items;


import MysticalComplexGame.Character;
import MysticalComplexGame.Scene;

import java.util.List;

public interface IItem
{

    String getDescription();
    void setDescription(String description);

    String getName();
    void setName(String name);

    void setInventoryDescription(String inventoryDescription);
    String getInventoryDescription();

    List<String> getTags();
}
