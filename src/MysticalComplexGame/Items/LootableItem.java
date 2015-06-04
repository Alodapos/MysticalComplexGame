package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public interface LootableItem
{
    boolean isEmpty();

    void loot(Player player);
}
