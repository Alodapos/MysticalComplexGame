package MysticalComplexGame.Commands;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;

public class PickCommand extends ICommandVerbItem
{
    private String invalidArgument;
    private String actionFailed;
    public PickCommand()
    {
        invalidArgument = "I can't see such a thing.";
        actionFailed = "This is not something I can pick!";
        key = "pick";
    }

    @Override
    public void executeCommand(IItem item)
    {
        if (!Player.getLocation().getItems().containsValue(item)) GameEngine.textOutput(invalidArgument);
        else if (!item.isPickable()) GameEngine.textOutput(actionFailed);
        else
        {
            Player.addToInventory(item);
            GameEngine.textOutput("Picked " + item.getName() + ".");
            Player.getLocation().removeItem(item);
        }
    }
}
