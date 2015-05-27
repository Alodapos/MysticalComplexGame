package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Vase extends IItem implements BreakableItem,ContainerItem {

    boolean broken;
    boolean looted;
    IItem loot;

    public Vase(IItem loot)
    {
        pickable = false;
        name = "vase";
        description = "An old, dusty, ceramic vase covered in webs sits atop the altar.";
        inventoryDescription = "";
        broken = false;
        looted = false;
        this.loot = loot;
    }

    @Override
    public void breakObject(Player player)
    {
        if (broken)
            GameEngine.textOutput("This is already broken.");
        else
        {
            broken = true;
            description = "You see the ceramic pieces of the vase you broke earlier atop the altar.";
            GameEngine.textOutput("You smash the vase with your boots and it shatters into pieces. What a badass you are! " + player.getName() + " the vase-slayer!!");
            dropLoot(player);
        }
    }

    @Override
    public void dropLoot(Player player)
    {
        if(!player.getInventory().containsValue(this.loot))
        {
            player.getLocation().addItem(loot);
            GameEngine.textOutput("After breaking the " + this.name + " a " + loot.getName() + " drops on the floor.");
        }
    }

    @Override
    public void pickLoot(Player player)
    {
        if(looted)
            GameEngine.textOutput("This is already looted.");
        else
        {
            looted = true;
            player.addToInventory(loot);
            GameEngine.textOutput("You loot the " + this.name + " and find a " + loot.getName() + "!");
            player.getLocation().removeItem(this.loot);
        }
    }
}