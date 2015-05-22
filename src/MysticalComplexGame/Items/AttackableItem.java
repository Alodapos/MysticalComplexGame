package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public interface AttackableItem
{
    void attack(Player player);

    boolean isAlive();
}
