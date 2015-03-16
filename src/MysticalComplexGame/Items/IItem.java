package MysticalComplexGame.Items;


import MysticalComplexGame.Characters.ICharacter;
import MysticalComplexGame.Scenes.IScene;

import java.util.ArrayList;

public interface IItem
{
    boolean isPickable();
    void setPickable(boolean canPick);

    boolean isUsable();
    void setUsable(boolean canUse);

    boolean isDropable();
    void setDropable(boolean canDrop);

    boolean isPullable();
    void setPullable(boolean canPull);

    boolean isPushable();
    void setPushable(boolean canPush);

    boolean isEnterable();
    void setEnterable(boolean canEnter);

    String getDescription();
    void setDescription(String description);

    String getName();
    void setName(String name);

    void setInventoryDescription(String inventoryDescription);
    String getInventoryDescription();

    void useItem(ICharacter player, ArrayList<IScene> scenes);
}
