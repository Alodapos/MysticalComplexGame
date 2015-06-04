package MysticalComplexGame.Commands;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.LiquidContainer;

public class FillCommand extends ICommandVerbWithItem
{
    private final String itemMissing;
    private final String invalidArgument;
    private final String isFull;

    public FillCommand()
    {
        key = "fill";
        invalidArgument = "This is not something that i can fill";
        itemMissing = "You don't have something like this with you.";
        isFull = "This is already filled.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getInventory().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof LiquidContainer))
            GameEngine.textOutput(invalidArgument);
        else if (((LiquidContainer)item).isFull())
            GameEngine.textOutput(isFull);
        else
            ((LiquidContainer) item).fill(player);
    }
}
