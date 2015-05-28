package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Vase extends IItem implements BreakableItem,ContainerItem,LootableItem
{
    private BreakableItemState broken;
    private LootableItemState looted;
    private LootableItemState empty;
    IItem loot;

    public Vase(IItem loot)
    {
        pickable = false;
        name = "vase";
        description = "An old but peculiar, dusty, ceramic vase covered in webs sits atop the altar.";
        inventoryDescription = "";
        this.loot = loot;
    }

    @Override
    public void breakObject(Player player)
    {
            description = "You see the ceramic pieces of the vase you broke earlier scattered on the ground.";
            this.broken = BreakableItemState.BROKEN;
            GameEngine.textOutput("You smash the vase with your boots and it shatters into pieces. What a badass you are! " + player.getName() + " the vase-slayer!!");
            dropLoot(player);
    }

    @Override
    public void dropLoot(Player player)
    {
        if(!player.getInventory().containsValue(this.loot))
        {
            this.empty = LootableItemState.EMPTY;
            player.getLocation().addItem(loot);
            GameEngine.textOutput("After breaking the " + this.name + " a " + loot.getName() + " drops on the floor.");
        }
    }

    @Override
    public void pickLoot(Player player)
    {
        if(!player.getInventory().containsValue(this.loot))
        {
            this.looted = LootableItemState.LOOTED;
            player.addToInventory(loot);
            GameEngine.textOutput("You loot the " + this.name + " and add a " + loot.getName() + " to your inventory!");
            player.getLocation().removeItem(this.loot);
        }
    }

    @Override
    public boolean isBroken()
    {
        return (broken == BreakableItemState.BROKEN);
    }

    @Override
    public boolean isLooted()
    {
        return (looted == LootableItemState.LOOTED);
    }

    @Override
    public boolean isEmpty()
    {
        return (empty == LootableItemState.EMPTY);
    }
}