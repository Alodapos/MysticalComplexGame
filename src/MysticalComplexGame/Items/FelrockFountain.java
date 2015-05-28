package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class FelrockFountain extends IItem implements ContainerItem,LootableItem
{

    IItem loot;
    private LootableItemState empty;
    private LootableItemState looted;

    public FelrockFountain(IItem loot)
    {
        pickable = false;
        name = "fountain";
        description = "There is also a very big, simple, stone fountain in the middle of the village, spouting crystal clear water from its holes.";
        inventoryDescription = "";
        this.loot = loot;
    }

    @Override
    public void pickLoot(Player player)
    {
        if(!player.getInventory().containsValue(this.loot))
        {
            this.looted = LootableItemState.LOOTED;
            player.addToInventory(loot);
            GameEngine.textOutput("You loot the " + this.name + " and find a " + loot.getName() + "!");
            if(loot.getName().equals("lucky coin"))
                GameEngine.textOutput("What a nice addition to your collection!");
            player.getLocation().removeItem(this.loot);
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