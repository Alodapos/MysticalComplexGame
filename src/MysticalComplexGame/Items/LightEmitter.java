package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public interface LightEmitter
{
    void light(Player player, IItem item);
    void quench();
    void attach(Player player, IItem item);
}
