package MysticalComplexGame.Items;

import MysticalComplexGame.Player;

public class SimpleWeapon extends IItem implements WeaponItem
{
    private Integer durability;
    private Integer damage;

    public SimpleWeapon(String name,int durability,int damage)
    {
        this.name = name.toLowerCase();
        description = "A simple iron " + this.name + " lies on the ground.";
        inventoryDescription = "A simple " + this.name + ".";
        pickable = true;
        setDurability(durability);
        setDamage(damage);
    }

    @Override
    public Integer getDurability()
    {
        return durability;
    }

    @Override
    public void setDurability(Integer durability)
    {
        if(durability>100) this.durability = 100;
        else if (durability<0) this.durability = 0;
        else this.durability = durability;
    }

    @Override
    public Integer getDamage()
    {
        return damage;
    }

    @Override
    public void setDamage(Integer damage)
    {
        if(damage<1) this.damage = 1;
        else this.damage = damage;
    }

    @Override
    public void equip(Player player)
    {
        player.equipWeapon(this);
    }

    @Override
    public void unequip(Player player)
    {
        player.unequipWeapon();
    }
}
