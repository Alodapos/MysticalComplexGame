package MysticalComplexGame.Commands;

import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Player;
import MysticalComplexGame.GameEngine;

public class PickCommand extends ICommandVerbItem
{
    private String invalidArgument;
    public PickCommand()
    {
        invalidArgument = "I can't see such a thing.";
        key = "pick";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getLocation().getItems().containsValue(item)) GameEngine.textOutput(invalidArgument);
        else item.pick(player);
    }
}
