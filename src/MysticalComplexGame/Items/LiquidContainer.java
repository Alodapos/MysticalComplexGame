package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public interface LiquidContainer
{
    void drink(Player player);
    void fill(Player player);
    void empty();
}
