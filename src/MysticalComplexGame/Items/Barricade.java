package MysticalComplexGame.Items;

import MysticalComplexGame.Connector;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

public class Barricade extends IItem implements BreakableItem {
    boolean broken;

    public Barricade() {
        pickable = false;
        name = "barricade";
        description = "Wooden planks pinned together form a barricade that blocks your way to the south, although it seems to be weak.";
        inventoryDescription = "";
        broken = false;
    }

    @Override
    public void breakObject(Player player)
    {
        if (broken) GameEngine.textOutput("This is already broken");
        else if (player.getEquippedWeapon() == null)
            GameEngine.textOutput("You need something stronger than your bare hands to break that.");
        else
        {
            broken = true;
            description = "Some wooden planks and pieces are scattered on the ground, its the barricade you broke not so long ago.";
            GameEngine.textOutput("You assault the wooden barricade with your " + ((IItem)player.getEquippedWeapon()).getName() + " until its completely wrecked!");
            for (Connector connection : player.getLocation().getConnections())
                connection.openConnection(this);
        }
    }
}