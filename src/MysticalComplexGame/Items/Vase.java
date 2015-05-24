package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Vase extends IItem implements BreakableItem,ContainerItem {

    boolean broken;
    IItem loot;

    public Vase(IItem loot) {
        pickable = false;
        name = "vase";
        description = "An old, dusty, ceramic vase covered in webs sits behind a pillar.";
        inventoryDescription = "";
        broken = false;
        this.loot = loot;
    }

    @Override
    public void breakObject(Player player)
    {
        if (broken) GameEngine.textOutput("This is already broken");
        else
        {
            broken = true;
            description = "You see the ceramic pieces of the vase you broke earlier behind the pillar";
            GameEngine.textOutput("You smash the vase with your boots and it shatters into pieces. What a badass you are! " + player.getName() + " the vase-slayer!!");
            dropLoot(player);
        }
    }

    @Override
    public void dropLoot(Player player)
    {
        player.getLocation().addItem(loot);
        GameEngine.textOutput("After breaking the " + this.name + " a " + this.loot + " drops on the floor.");
    }
}