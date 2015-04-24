package MysticalComplexGame.Commands;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.IKeyItem;
import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;

public class DropCommand extends ICommandVerbItem
{
    private String invalidArgument;
    private String actionFailed;
    public DropCommand()
    {
        invalidArgument = "I do not have this item with me.";
        actionFailed = "I will not drop this, it's very important!";
        key = "drop";
    }

    @Override
    public void executeCommand(IItem item)
    {
        if (!Player.getInventory().containsValue(item)) GameEngine.textOutput(invalidArgument);
        else if (item instanceof IKeyItem) GameEngine.textOutput(actionFailed);
        else
        {
            Player.getLocation().addItem(item);
            GameEngine.textOutput("Dropped " + item.getName() + ".");
            Player.removeFromInventory(item);
        }
    }
}
