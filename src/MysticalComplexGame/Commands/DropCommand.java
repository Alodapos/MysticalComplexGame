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
        invalidArgument = "You do not have this item with you.";
        actionFailed = "You should not drop this, it's very important!";
        key = "drop";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getInventory().containsValue(item)) GameEngine.textOutput(invalidArgument);
        else if (item instanceof IKeyItem) GameEngine.textOutput(actionFailed);
        else
        {
            player.getLocation().addItem(item);
            GameEngine.textOutput("Dropped " + item.getName() + ".");
            player.removeFromInventory(item);
        }
    }
}
