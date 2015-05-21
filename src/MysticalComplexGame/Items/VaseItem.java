package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

import java.util.Scanner;

public class VaseItem extends IItem implements BreakableItem {
    boolean broken;

    public VaseItem() {
        pickable = false;
        name = "vase";
        description = "An old, dusty, ceramic vase covered in webs sits behind a pillar.";
        inventoryDescription = "";
        broken = false;
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
        }
    }
}