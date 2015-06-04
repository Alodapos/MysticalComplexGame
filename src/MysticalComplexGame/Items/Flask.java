package MysticalComplexGame.Items;

import MysticalComplexGame.Connector;
import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;

public class Flask extends IItem implements LiquidContainer,KeyItem
{
    private boolean full;
    private final String drinkSuccess;
    private final String fillSuccess;
    private final String noSource;
    private final IItem toFillWith;
    private final Connector toOpen;
    private final int thirstRestored;

    public Flask(Connector toOpen,IItem toFillWith,int thirstRestored)
    {
        pickable = true;
        name = "leather flask";
        description = "There is a small sized leather flask on a wooden table.";
        inventoryDescription = "A small flask.";
        drinkSuccess = "You drink from the " + name + " and quench your thirst.";
        fillSuccess = "You fill your flask with "+ toFillWith.getName() +".";
        noSource = "There is no water source nearby to fill this.";
        this.toFillWith = toFillWith;
        this.toOpen = toOpen;
        this.thirstRestored = thirstRestored;
    }

    @Override
    public boolean isFull()
    {
        return full;
    }

    @Override
    public void drink(Player player)
    {
        player.setThirstLevel(thirstRestored);
        GameEngine.textOutput(drinkSuccess);
        full = false;
    }

    @Override
    public void fill(Player player)
    {
        if (player.getLocation().getItems().containsValue(toFillWith))
        {
            GameEngine.textOutput(fillSuccess);
            full = true;
        }
        else GameEngine.textOutput(noSource);
    }

    @Override
    public void empty()
    {
        GameEngine.textOutput("You pour the water to the ground until the " + name + " is completely empty.");
        full = false;
    }

    @Override
    public void pick(Player player)
    {
        super.pick(player);
        toOpen.openConnection();
    }
}
