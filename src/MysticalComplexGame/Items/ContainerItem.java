package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public interface ContainerItem
{
    void dropLoot(Player player);

    void pickLoot(Player player);
}
