package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class FelrockFountain extends IItem implements ContainerItem,LootableItem
{
    IItem luckyCoinLoot, turquoisePebbleLoot, pinkPebbleLoot;
    private LootableItemState empty;
    private LootableItemState looted;

    public FelrockFountain(IItem luckyCoinLoot, IItem turquoisePebbleLoot, IItem pinkPebbleLoot)
    {
        pickable = false;
        name = "fountain";
        description = "There is also a very big, simple, stone fountain in the middle of the village, spouting crystal clear water from its holes.";
        inventoryDescription = "";
        this.luckyCoinLoot = luckyCoinLoot;
        this.turquoisePebbleLoot = turquoisePebbleLoot;
        this.pinkPebbleLoot = pinkPebbleLoot;
    }

    @Override
    public void pickLoot(Player player)
    {
        if (!player.getInventory().containsValue(this.luckyCoinLoot))
        {
            player.addToInventory(luckyCoinLoot);
            GameEngine.textOutput("You loot the " + this.name + " and find a " + luckyCoinLoot.getName() + "!\n" +
                    "What a nice addition to your collection!");
            player.getLocation().removeItem(this.luckyCoinLoot);
        }
        else if (!player.getInventory().containsValue(this.turquoisePebbleLoot))
        {
            player.addToInventory(turquoisePebbleLoot);
            GameEngine.textOutput("You loot the " + this.name + " and find a " + turquoisePebbleLoot.getName() + "!\n" +
                    "Maybe next time you'll be more fortunate...");
            player.getLocation().removeItem(this.turquoisePebbleLoot);
        }
        else if(!player.getInventory().containsValue(this.pinkPebbleLoot))
        {
            player.addToInventory(pinkPebbleLoot);
            GameEngine.textOutput("You loot the " + this.name + " and find a " + pinkPebbleLoot.getName() + "!\n" +
                    "Maybe next time you'll be more fortunate...");
            player.getLocation().removeItem(this.pinkPebbleLoot);
        }
    }

    @Override
    public void dropLoot(Player player)
    {
        
    }

    @Override
    public  boolean isEmpty()
    {
        return (empty == LootableItemState.EMPTY);
    }

    @Override
    public boolean isLooted()
    {
        return (looted == LootableItemState.LOOTED);
    }

}