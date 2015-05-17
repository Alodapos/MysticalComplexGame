package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public interface WeaponItem
{
    void equip(Player player);

    void unequip(Player player);

    public Integer getDurability();

    public void setDurability(Integer durability);

    public Integer getDamage();

    public void setDamage(Integer damage);
}
