package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.LightEmitter;
import MysticalComplexGame.Player;

public class QuenchCommand extends ICommandVerbWithItem
{
    private final String itemMissing;
    private final String invalidArgument;
    private final String quenchedFailed;

    public QuenchCommand()
    {
        key = "quench";
        invalidArgument = "This is not something that I can quench.";
        itemMissing = "You don't have or see such a thing.";
        quenchedFailed = "You cannot quench that, it is already quenched.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getLocation().getItems().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof LightEmitter))
            GameEngine.textOutput(invalidArgument);
        else if (!(((LightEmitter) item).isBurning()))
            GameEngine.textOutput(quenchedFailed);
        else
            ((LightEmitter)item).quench();
    }
}
