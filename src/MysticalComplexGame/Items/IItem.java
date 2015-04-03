package MysticalComplexGame.Items;


import MysticalComplexGame.Character;
import MysticalComplexGame.Scene;

import java.util.List;

public interface IItem
{

    String getDescription();

    String getName();
    void setName(String name);

    String getInventoryDescription();

    List<String> getTags();
}
