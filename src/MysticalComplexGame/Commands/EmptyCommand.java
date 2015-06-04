package MysticalComplexGame.Commands;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.LiquidContainer;

public class EmptyCommand extends ICommandVerbWithItem
{
    private final String itemMissing;
    private final String invalidArgument;
    private final String isEmpty;

    public EmptyCommand()
    {
        key = "empty";
        invalidArgument = "This is not something that i can empty.";
        itemMissing = "You don't have something like this with you.";
        isEmpty = "This is already empty!";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getInventory().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof LiquidContainer))
            GameEngine.textOutput(invalidArgument);
        else if (!((LiquidContainer)item).isFull())
            GameEngine.textOutput(isEmpty);
        else
            ((LiquidContainer)item).empty();
    }
}
