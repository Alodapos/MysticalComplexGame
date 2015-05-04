package MysticalComplexGame.Commands;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.LiquidContainer;

public class DrinkCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;

    public DrinkCommand()
    {
        key = "drink";
        invalidArgument = "This is not something that i can drink from...";
        itemMissing = "You don't have something like this with you.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getInventory().containsValue(item)) GameEngine.textOutput(itemMissing);
        else if (!(item instanceof LiquidContainer)) GameEngine.textOutput(invalidArgument);
        else
        {
            LiquidContainer itemArgument = (LiquidContainer) item;
            itemArgument.drink(player);
        }
    }
}
