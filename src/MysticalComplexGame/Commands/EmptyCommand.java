package MysticalComplexGame.Commands;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.LiquidContainer;


public class EmptyCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;

    public EmptyCommand()
    {
        key = "empty";
        invalidArgument = "This is not something that i can empty.";
        itemMissing = "You don't have something like this with you.";
    }

    @Override
    public void executeCommand(IItem item)
    {
        if (!Player.getInventory().containsValue(item)) GameEngine.textOutput(itemMissing);
        else if (!(item instanceof LiquidContainer)) GameEngine.textOutput(invalidArgument);
        else
        {
            LiquidContainer itemArgument = (LiquidContainer) item;
            itemArgument.empty();
        }
    }
}