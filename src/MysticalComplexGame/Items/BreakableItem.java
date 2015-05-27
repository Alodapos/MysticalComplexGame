package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public interface BreakableItem
{
    void breakObject(Player player);

    boolean isBroken();
}
