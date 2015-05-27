package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public interface LightEmitter
{
    void light(Player player);

    void quench();

    boolean isBurning();
}
