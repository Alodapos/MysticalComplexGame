package MysticalComplexGame.Commands;

import MysticalComplexGame.GameEngine;
import MysticalComplexGame.Items.IItem;
import MysticalComplexGame.Items.LightEmitter;
import MysticalComplexGame.Player;


public class LightCommand extends ICommandVerbItem
{
    private String itemMissing;
    private String invalidArgument;
    private String alreadyBurning;

    public LightCommand()
    {
        key = "light";
        invalidArgument = "This is not something that you can "+key+".";
        itemMissing = "You don't see such a thing.";
        alreadyBurning = "This is already burning, you can't relight it.";
    }

    @Override
    public void executeCommand(Player player,IItem item)
    {
        if (!player.getLocation().getItems().containsValue(item))
            GameEngine.textOutput(itemMissing);
        else if (!(item instanceof LightEmitter))
            GameEngine.textOutput(invalidArgument);
        else if (((LightEmitter) item).isBurning())
            GameEngine.textOutput(alreadyBurning);
        else
            ((LightEmitter)item).light(player);
    }
}
