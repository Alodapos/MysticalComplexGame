package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public interface WeaponItem
{
    void equip(Player player);

    void unequip(Player player);

    Integer getDurability();

    void setDurability(Integer durability);

    Integer getDamage();

    void setDamage(Integer damage);
}
