package MysticalComplexGame.Items;

/**
 * Created by sakis on 12-Mar-15.
 */
public interface IItem
{


    boolean isCanBePicked();

    void setCanBePicked(boolean canPick);

    boolean isUseable();

    void setUseable(boolean canUse);

    String getDescription();

    void setDescription(String description);

    String getName();

    void setName(String name);

    void setInventoryDescription(String inventoryDescription);

    String getInventoryDescription();

    //boolean isDropable();

    //void setDropable(boolean canDrop);

    //boolean isPullable();

    //void setPullable(boolean canPull);

    //boolean isPushable();

    //void setPushable(boolean canPush);

    //boolean isPassable();
    //COULD BE APPLIED TO A BRIDGE OR SMALL AREA IF BRIDGE OR AREA IS CONSIDERED AN ITEM (CLASS)
    //void setPassable(boolean canPass);
}
