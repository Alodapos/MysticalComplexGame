package MysticalComplexGame.Items;

import MysticalComplexGame.Connector;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Barricade extends IItem implements BreakableItem {

    private boolean broken;
    private Connector toOpen;

    public Barricade(Connector toOpen) {
        pickable = false;
        name = "barricade";
        description = "Wooden planks pinned together form a barricade that blocks your way to the south, although it seems to be weak.";
        inventoryDescription = "";
        broken = false;
        this.toOpen = toOpen;
    }

    @Override
    public void breakObject(Player player)
    {
        if (broken)
            GameEngine.textOutput("This is already broken");
        else
        {
            broken = true;
            description = "Some wooden planks and pieces are scattered on the ground, it's the barricade you broke not so long ago.";
            GameEngine.textOutput("You assault the wooden barricade until it's completely wrecked!");
            toOpen.openConnection();
        }
    }
}