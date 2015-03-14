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
}
