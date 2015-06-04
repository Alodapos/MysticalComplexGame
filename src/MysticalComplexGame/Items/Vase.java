package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Vase extends IItem implements BreakableItem,LootableItem
{
    private boolean broken;
    private IItem loot;

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
        broken = true;
        GameEngine.textOutput("You smash the vase with your boots and it shatters into pieces. What a badass you are! " + player.getName() + " the vase-slayer!!");
        if(!isEmpty())
        {
            player.getLocation().addItem(loot);
            GameEngine.textOutput("After breaking the " + this.name + " a " + loot.getName() + " drops on the floor.");
            loot = null;
        }
    }

    @Override
    public void loot(Player player)
    {
        if(!isEmpty() && !isBroken())
        {
            player.addToInventory(loot);
            GameEngine.textOutput("You loot the " + this.name + " and add a " + loot.getName() + " to your inventory!");
            loot = null;
        }
    }

    @Override
    public boolean isBroken()
    {
        return broken;
    }

    @Override
    public boolean isEmpty()
    {
        return loot == null;
    }
}