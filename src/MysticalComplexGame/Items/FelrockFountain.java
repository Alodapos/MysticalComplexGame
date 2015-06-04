package MysticalComplexGame.Items;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class FelrockFountain extends IItem implements LootableItem
{
    private final List<IItem> loots = new LinkedList<>();

    public FelrockFountain(IItem...loots)
    {
        pickable = false;
        name = "fountain";
        description = "There is also a very big, simple, stone fountain in the middle of the village, spouting crystal clear water from its holes.";
        inventoryDescription = "";
        this.loots.addAll(Arrays.asList(loots));
    }

    @Override
    public void loot(Player player)
    {
        Random lootRandom = new Random();
        int lootIndex = lootRandom.nextInt(loots.size());
        player.addToInventory(loots.get(lootIndex));
        GameEngine.textOutput("You looted a " + loots.get(lootIndex).getName() + " from the " + this.name + ".");
        loots.remove(loots.get(lootIndex));
    }

    @Override
    public  boolean isEmpty()
    {
        return loots.isEmpty();
    }
}